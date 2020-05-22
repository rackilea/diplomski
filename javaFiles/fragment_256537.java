List<Widget> temp =
    list.stream()
        .sorted(comparing(Widget::weight).reversed())
        .collect(toList());
temp.stream()
    .limit((long)(temp.size() * 0.5))
    .forEach(System.out::println);