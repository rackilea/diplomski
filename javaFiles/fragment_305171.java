while(i.hasNext()) {
        Object temp = i.next(); //goto next one #1, #2, #3, #4, #5
        System.out.println(temp);
        Map.Entry me = (Map.Entry)temp; 
        String currentSegString = (String) me.getKey();

        System.out.println(currentKey+"**************"); //output #1,2,3,4,5
    }