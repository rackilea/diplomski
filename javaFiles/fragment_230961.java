class Example {
    private int valueOne = 1;
    public Example(int value)
    {
        System.out.println(valueOne);
        valueOne = value;
        System.out.println(valueOne);
    }
}

...

public static void main(String[] args) {
    new Example(2);
}