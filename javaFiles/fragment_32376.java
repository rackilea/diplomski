public List<HashMap<String, Object>> convertCSVRecordToList() {

    String csvFile = "your_file_name.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";
    HashMap<String, Object> Map = new HashMap<String, Object>();

    List<HashMap<String, Object>> MapList = new ArrayList<HashMap<String, Object>>();

    try {

        br = new BufferedReader(new FileReader(csvFile));

        while ((line = br.readLine()) != null) {

            System.out.println(line);

            String[] data = line.split(cvsSplitBy);         

            Map.put("filed_name", data[3]);
            Map.put("field_name", data[0]);
            Map.put("field_name", data[2]);
            Map.put("fiels_name", data[1]);

            MapList.add(Map);
            Map = new HashMap<String, Object>();                
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
     catch (IOException e) {
        e.printStackTrace();
    }

    return MapList;
}