public static String getString(List<Integer> list){
    return list.stream()
               .map(i -> {
                    if (i%2==0) {
                        return "e"+i;
                    } else {
                        return "u"+i;
                    }
                })
               .collect(Collectors.joining(","));
}