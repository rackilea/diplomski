stream.collect(Collectors.collectingAndThen(Collectors.toList(),
    joiningOxfordComma()));

public static Function<List<String>, String> joiningOxfordComma() {
    return list -> {
                int last = list.size() - 1;
                if (last < 1) return String.join("", list);
                if (last == 1) return String.join(" and ", list);
                return String.join(", and ",
                    String.join(", ", list.subList(0, last)),
                    list.get(last));
            };
}