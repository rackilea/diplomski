for (Entry<String, HashMap<String, Integer>> temp : wordCountforFile.entrySet()) {
    System.out.println(temp.getKey());
    for(Entry<String, Integer> temp1 : temp.entrySet()){
        // ...
    }
}