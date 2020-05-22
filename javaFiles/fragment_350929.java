public static void main(String[] args) throws IOException
{
    File file = new File("xml/input1.xml");

    // main data structure
    // key - corporate email
    // value - set of distinct companies
    // (does this make sense? a corporate email belongs to one company, no? 
    Map<String, Set<String>> compIdmap = new HashMap<String, Set<String>>();

    // making use of Java 7 try-with-resources to auto close the file after use 
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line, compName = "", email = "";
        while ((line = br.readLine()) != null) {
            if (line.contains("<CompanyName>")) {
                compName = StringUtils.substringBetween(line, "<CompanyName>", "</CompanyName>");
            }
            if (line.contains("<CorporateEmailAddress>")) {
                email = StringUtils.substringBetween(line, "<CorporateEmailAddress>", "</CorporateEmailAddress>"); 
                if (email == null || email.equals("")) email = "unknown";
                Set<String> companiesSet = compIdmap.containsKey(email) ? compIdmap.get(email) : new HashSet<>();
                companiesSet.add(compName);
                compIdmap.put(email, companiesSet);
            }
        }
        System.out.println("mapping :" + compIdmap);
        BufferedWriter br1 = new BufferedWriter(new FileWriter("xml/mapping.txt"));
        Iterator it = compIdmap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            br1.write(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}