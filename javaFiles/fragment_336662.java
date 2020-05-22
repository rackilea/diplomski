String[] strings = new String[5];

for (int i = 0; i < 5; i++) {
    List<String> subList = list.subList(100 * i, 100 * (i + 1));

    StringBuilder sb = new StringBuilder(subList.stream().mapToInt(String::length).sum());

    for (int j = 0; j < 100; j++) {
        sb.append(subList.get(i));
    }

    strings[i] = sb.toString();
}