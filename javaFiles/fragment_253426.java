//change the method signature to return List<Integer>
public static List<Integer> odd(ArrayList<Integer> list) {
        if (list.isEmpty()) { throw new Error(); }
        List<Integer> toRemove = new ArrayList<>();

        for (int si : list) {
            if (si % 2 != 0) { toRemove.add(si); }
        }

        list.removeAll(toRemove);
        return list;//return list, not int
    }