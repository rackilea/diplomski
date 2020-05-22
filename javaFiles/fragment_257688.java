public static ArrayList<String> combine(ArrayList<String> list) {
    ArrayList<String> newList = new ArrayList<>();

    for (int i = 0; i < list.size(); i = i + 2) {
        // get first number
        String firstNumber = list.get(i);

        // check if second number exists
        if (i + 1 < list.size()) {
            String secondNumber = list.get(i + 1);
            // add concatenated string to new list
            newList.add(firstNumber + " " + secondNumber);
        } else {
            // no second number exists, add the remaining number
            newList.add(firstNumber);
        }
    }

    return newList;
}