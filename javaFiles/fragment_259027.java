String str1 = "[0.7419,0.7710,0.2487]";
            String str2 = "[\"0.7710\",\"0.7419\",\"0.2487\"]";
            String jsonArray = new JSONArray(str2).toString();
            List<String> list1=new ArrayList<String>(Arrays.asList(str1.replace("[", "").replace("]", "").split(",")));
            List<String> list2=new ArrayList<String>(Arrays.asList(jsonArray.replace("[", "").replace("]", "").replace("\"", "").split(",")));
            Collections.sort(list1);
            Collections.sort(list2);
            if(list1.equals(list2)){
                  System.out.println("str1 and str2 are equal");
            }