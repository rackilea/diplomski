public static String factorise(String input) {
        String result = "";
        Map<String, Integer> molecules = new LinkedHashMap<>();
        String[] res = input.split("\\|");
        for (String t : res) {
            //Check if we already have this element in our map
            if (!molecules.containsKey(t)) {
                //If not then add it and set the count to 1
                molecules.put(t, 1);
            } else {
                //If we do then update the count by 1
                molecules.put(t, molecules.get(t) + 1);
            }
        }
        //Iterate through each molecule
        for (String key : molecules.keySet()) {
            if (molecules.get(key) == 1) {
                //If the count is only at one, then we just need to append it.
                result += key;
            } else {
                //Otherwise, we need the parentheces and the number of repetitions followed after
                result = result + "(" + key + ")" + molecules.get(key);
            }
        }
        return result;
    }