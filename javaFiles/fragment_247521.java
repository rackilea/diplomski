public List<Map<String, String>> myfunction(String str1[][]) {
    List<Map<String, String>> travelgl1 = new ArrayList<Map<String, String>>();
    for (int i = 0; i < str1.length; i++) {
        Map<String, String> map = new HashMap<String, String>();
        for (int j = 0; j < 6; j++) {
            if (j == 0)
                map.put("Duration", str1[i][j]);
            else if (j == 1)
                map.put("Walking time", str1[i][j]);
            else if (j == 2)
                map.put("Direction", str1[i][j]);
            else if (j == 3)
                map.put("Departure", str1[i][j]);
            else if (j == 4)
                map.put("Arrival", str1[i][j]);
            else if (j == 5)
                map.put("End station", str1[i][j]);
        }
        travelgl1.add(map);
    }
    return travelgl1;
}