public static int find(ArrayList<String> names) {


    for (i = 0; i < names.size(); i = i + 1) {
        String s = names.get(i);
        for (int j = i + 1; j < names.size(); j = j + 1) {
            if (s.equals(names.get(j))) {

                return j;

            }
        }

    }
    return -1;
}