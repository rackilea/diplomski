public static void main(String[] args) {
    Outer[] outers = {
            new Outer(new Inner("a")),
            new Outer(new Inner("b")),
            new Outer(new Inner("c")),
            new Outer(new Inner("a")),
            new Outer(new Inner("b")),
            new Outer(new Inner("c")),
    };

    Map<String, Outer> OutersById = Arrays.stream(outers).collect(Collectors.toMap(outer -> outer.inner.id, outer -> outer));

    OutersById.forEach((k,v)->System.out.println(k+", "+v));
}