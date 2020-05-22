public static void main(String[] args)
{
    File file = new File("xml/input1.xml");

    // contains email + " " + company 
    Set<String> emailAndCompanySet = new HashSet<>();

    // making use of Java 7 try-with-resources to auto close the file after use
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line, compName = "", email = "";
        while ((line = br.readLine()) != null) {
            if (line.contains("<CompanyName>")) {
                compName = StringUtils.substringBetween(line, "<CompanyName>", "</CompanyName>");
            }
            if (line.contains("<CorporateEmailAddress>")) {
                email = StringUtils.substringBetween(line, "<CorporateEmailAddress>", "</CorporateEmailAddress>");
                if (email == null || email.equals(""))
                    email = "unknown";
                emailAndCompanySet.add(email + " " + compName);

            }
        }
        System.out.println("mapping :" + emailAndCompanySet);
        BufferedWriter br1 = new BufferedWriter(new FileWriter("xml/mapping.txt"));
        for (String emailAndCompany : emailAndCompanySet) {
            System.out.println(emailAndCompany);
            br1.write(emailAndCompany);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}