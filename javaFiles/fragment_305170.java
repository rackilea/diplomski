while(i.hasNext()) {

        Map.Entry me = (Map.Entry)i.next(); //goto next one #1, #2, #3, #4, #5
        String currentSegString = (String) me.getKey();

        System.out.println(currentKey+"**************"); //output #1,2,3,4,5
    }