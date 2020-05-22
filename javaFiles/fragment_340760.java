String str = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15";
        String[] ar_str = str.split(",");
        List<String> list = Arrays.asList(ar_str);

        int count = 4;
        int fromIndex = 0;
        int toIndex = count;
        for(int i=0;i<list.size()/count;i++){
            fromIndex = i * count;
            toIndex = fromIndex + count;
            List<String> temp = list.subList(fromIndex, toIndex);
            System.out.println(temp); //Convert List into comma separated String
        }
        if(list.size()%count > 0){
            System.out.println(list.subList(toIndex, list.size()));
        }