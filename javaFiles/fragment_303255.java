public static int find_minimum_length(List<String> a) {
    if (a == null || a.size() == 0) {
        return -1;
    }
    int position = 0;
    int smallest = a.get(0).length();

    // start iterating your for loop at 1, not 0
    for (int i=1; i < a.size(); i++) {
        if (a.get(i).length() < smallest) {
            smallest = a.get(i).length();
            position = i;
        }
    }

    return position;
}

public static List<String> remove_minimum_length(List<String> a) {
    int index = find_minimum_length(a);

    if (index != -1) {
        a.remove(index);
    }

    return a;
}