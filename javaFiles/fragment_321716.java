public interface ItemOrBlock // think of a better name
{
    public void func1();

    public void func2();
}

public class BlockWrapper implements ItemOrBlock 
{
    private Block block;

    public BlockWrapper (Block block) {
        this.block = block;
    }

    public void func1()
    {
        block.func1();
    }

    public void func2()
    {
        block.func2();
    }

}