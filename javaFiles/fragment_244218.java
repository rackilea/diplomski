public class TestADT
{
    private final int x;

    public TestADT(int x)
    {
        this.x = x;
    }

    public static TestADT Add3(TestADT num)
    {
        int ex = (num.x + 3);
        return (new TestADT(ex));
    }

    public String toString()
    {
        return(x + "");
    }

    public static void main(String[] args)
    {
        TestADT test = new TestADT(2);
        System.out.println(Add3(test));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestADT testADT = (TestADT) o;

        if (x != testADT.x) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return x;
    }
}