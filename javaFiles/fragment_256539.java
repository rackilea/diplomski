Criterion topPercent(Comparator<Widget> cmp, double pct) {
    return stream -> {
        List<Widget> temp =
            stream.sorted(cmp).collect(toList());
        return temp.stream()
                   .limit((long)(temp.size() * pct));
    };
}