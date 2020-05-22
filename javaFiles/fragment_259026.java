String str1 = "[0.7419,0.7710,0.2487]";
        String str2 = "[\"0.7710\",\"0.7419\",\"0.2487\"]";
        String jsonArray = new JSONArray(str2).toString();
        Set<String> set1 = new TreeSet<String>(Arrays.asList(str1.replace("[", "").replace("]", "").split(",")));
        Set<String> set2 = new TreeSet<String>(Arrays.asList(jsonArray.replace("[", "").replace("]", "").replace("\"", "").split(",")));
        if(set1.equals(set2)){
             System.out.println(" str1 and str2 are equal");
       }