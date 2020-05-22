public static Map<Integer,Integer> bijectiveMap(int n) {
        List<Integer> values = new ArrayList<>(n);
        for (int i=0 ; i<n ; i++)
            values.add(i);
        Collections.shuffle(values);

        Map<Integer,Integer> result = new HashMap<>();
        for (int i=0 ; i<n ; i++)
            result.put(i,values.get(i));
        return result;
    }