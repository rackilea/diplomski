String str1 = "In the morning\r\n" + 
                "              I have breakfast\r\n" + 
                "              After";

        String str2 = "In the afternoon\r\n" + 
                "              I have dinner\r\n" + 
                "              Before";         

        StringBuilder buff = new StringBuilder();           

        List<String> list1 = new ArrayList<String>(Arrays.asList(str1.split("\r\n")));
        List<String> list2 = new ArrayList<String>(Arrays.asList(str2.split("\r\n")));

        if(list1.size() == list2.size()){           
            for(int i = 0; i<list1.size(); i++){
                buff.append(list1.get(i)).append("\r\n")
                    .append(list2.get(i)).append("\r\n");
            }           
        }

        System.out.print(buff.toString());