//Create 5 different shufflings of the words
    List<ArrayList<String>> listOlists = new ArrayList<ArrayList<String>>();
    for (int i = 0; i < 5; i++) {
        ArrayList<String> shuffle = new ArrayList<String>();
        for (String s : words) {
            shuffle.add(s);
        }//end for
        Collections.shuffle(shuffle);
        listOlists.add(shuffle);
        System.out.println(shuffle);
    }
    //access it later
    for (List<String> arrayList : listOlists) {
        System.out.println(arrayList);
    }