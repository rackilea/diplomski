static ArrayList<String> mapAll1(String input) {
    int len = input.length();
    ArrayList<String> outputs = new ArrayList<>();
    //String[] outputs = new String[len];
    ArrayList<String> outputStrings = new ArrayList<>();
    for (int i = 0; i < len; i++)
        outputs.add(mapOne(Character.toString(input.charAt(i))));

    if (len == 1)
        for (int i = 0; i < outputs.get(len - 1).length(); i++)
            outputStrings = outputs;

    else {
        outputStrings = IntStream
                .range(0, len)
                // get last n strings from outputs, starts from last
                .mapToObj(i -> outputs.get(len - (i + 1)))
                // transform List<String> into List<List<String>>,
                .map(x -> new ArrayList<>(x.chars()
                        .mapToObj(Character::toString)
                        .collect(Collectors.toList()))
                )
                // reduce
                .reduce(new ArrayList<>(), (acc, list) -> new ArrayList<>(
                        acc.isEmpty() ? list : list.stream()
                                .flatMap(prefix -> acc.stream()
                                        .map(tail -> prefix + tail)
                                ).collect(Collectors.toList())));
    }

    return outputStrings;
}