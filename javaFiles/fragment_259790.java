public Stream<Point> stream(int hstep, int vstep) {
    return IntStream.range(0, height / vstep)
            .mapToObj(y -> IntStream.range(0, width / hstep)
                    .mapToObj(x -> new Point(start.x + x * hstep, start.y + y * vstep)))
            .flatMap(Function.identity());
}