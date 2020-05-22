void generate(ArrayList<ArrayList<String>> lists,
                  ArrayList<String> result, int index) {
        if (index >= lists.size()) {
            System.out.println(String.valueOf(result));
            return;
        }
        ArrayList<String> list = lists.get(index);
        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(i));
            generate(lists, result, index + 1);
            result.remove(result.size() - 1);
        }
    }
}