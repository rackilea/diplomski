while(i.hasNext()) { 
        System.out.println(i.next()); //skip one  #1, #3, #5
        Map.Entry me = (Map.Entry)i.next(); //goto next one #2, #4
        String currentSegString = (String) me.getKey();

        System.out.println(currentKey+"**************"); //output #2,4
    }