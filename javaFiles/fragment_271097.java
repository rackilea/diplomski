public static void main(String[] args) throws IOException, FileNotFoundException {
    String line = "";
    String cvsSplitBy = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

    try {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/rj.csv"));
        Map<String, List<String>> questListByMinistry = new HashMap<>();
        Map<String, Integer> questCountByMinistry = new HashMap<>();
        //skip the first line 
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] rj = line.split(cvsSplitBy);
            questListByMinistry.computeIfAbsent(rj[2], k -> new ArrayList<>()).add(rj[3]);
            questCountByMinistry.compute(rj[2], (k,v) -> v==null? 1 : v+1);                    
        }
        System.out.println(questCountByMinistry);
        System.out.println(questListByMinistry);
    } catch (IOException e) {
        e.printStackTrace();
    }
}