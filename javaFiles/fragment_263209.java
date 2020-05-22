@SomeInfo(author = "Bob", year = 1993)
class Foo {
    @SomeInfo(author = "me", somethingElse = "abcdefg")
    private int x = 5;

    @SomeInfo(author = "Fred", column = "order")
    public int getX() {
        return x;
    }
}