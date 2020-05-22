public static ArrayList<String> getTiles(ArrayList<String> input,StringSplitter splitter) {

    int initSize = input.size();
    for(int i = 0; i < initSize; i++) {

        String source = input.remove(0); //Remove from head
        input.addAll(splitter.splitString(source)); //Add to end

    }

    return input;

}