public static ArrayList<Integer> lengths(ArrayList<String> strings) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (String item : strings) {
            list.add(item.length());//add length to list
        }
        return list;
}