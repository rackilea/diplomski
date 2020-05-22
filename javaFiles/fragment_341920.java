private class MyClass {
    private String first;
    private String second;

    MyClass(String first, String second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "MyClass [first=" + first + ", second=" + second + "]";
    }

}


List<MyClass> list = Files.lines(path)
        .map(line -> line.split(";"))
        .map(splittedLine -> new MyClass(splittedLine[0], splittedLine[1]))
        .collect(Collectors.toList());

System.out.println(list);