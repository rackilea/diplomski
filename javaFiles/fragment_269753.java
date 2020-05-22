public static void main(String[] args) {
        String[] vegetablesSet = { "Pepper", "Cabbage", "Tomato", "Carrot", "Beans", "Cucumber", "Peas" };
        Set<Set<String>> result = new HashSet<>();      
        combinations(vegetablesSet, new ArrayList<>(), result, 5, 0);
        result.forEach(System.out::println);
    }

    public static void combinations(String[] values, List<String> current, Set<Set<String>> accumulator, int size, int pos) {
        if (current.size() == size) {
            Set<String> toAdd = current.stream().collect(Collectors.toSet());
            if (accumulator.contains(toAdd)) {
                throw new RuntimeException("Duplicated value " + current);
            }
            accumulator.add(toAdd);
            return;
        }
        for (int i = pos; i <= values.length - size + current.size(); i++) {
            current.add(values[i]);
            combinations(values, current, accumulator, size, i + 1);
            current.remove(current.size() - 1);
        }
    }