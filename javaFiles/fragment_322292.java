public static List<String> getCombinations(String prefix, String ending, String[]... arrays) {
    List<String> results = new ArrayList<>();
    Stack<String[]> combinations = new Stack<>();
    combinations.add(new String[arrays.length]);

    while (!combinations.isEmpty()) {
        String[] currentArray = combinations.pop();

        if (currentArray[arrays.length - 1] == null) {
            for (int i = 0; i < arrays.length; i++) {
                if (currentArray[i] == null) {
                    for (int j = 0; j < arrays[i].length; j++) {
                        String[] newArray = currentArray.clone();
                        newArray[i] = arrays[i][j];
                        combinations.add(newArray);
                    }

                    break;
                }

            }
        } else {
            StringBuilder stringBuilder = new StringBuilder(prefix);
            for (String string : currentArray) {
                stringBuilder.append(string);
            }
            stringBuilder.append(ending);
            results.add(stringBuilder.toString());
        }
    }

    return results;
}