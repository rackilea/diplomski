public static LinkedList<Integer> PositionFinder(String source, String pattern) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        int index = source.indexOf(pattern);
        if (index == -1) return list;
        list.add(index);
        while (true) {
            index = source.indexOf(pattern, index + 1);
            if (index == -1) return list;
            list.add(index);
        }

    }