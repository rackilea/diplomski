Stream<Widget> top50PercentByWeight(Stream<Widget> stream) {
    List<Widget> temp =
        stream.sorted(comparing(Widget::weight).reversed())
              .collect(toList());
    return temp.stream()
               .limit((long)(temp.size() * 0.5));
}