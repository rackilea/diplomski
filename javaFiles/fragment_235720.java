Criterion topPercentFromRange(Comparator<Widget> cmp, double from, double to) {
    return stream -> {
        List<Widget> temp =
            stream.sorted(cmp).collect(toList());
        return temp.stream()
                   .skip((long)(temp.size() * from))
                   .limit((long)(temp.size() * (to - from)));
    };
}