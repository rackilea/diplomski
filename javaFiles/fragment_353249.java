public class Foo
    implements ActionListener
{
    private final OuterClass target;

    public Foo(final OuterClass t)
    {
        target = t;
    }

    public void actionPerformed(final ActionEvent e)
    {
        target.targetClassMethod();
    }
}