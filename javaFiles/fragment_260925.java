public class MyForm : GCanvas
{
    private GLabel _turns = new GLabel();

    public MyForm()
    {
        add(_turns);
    }

    private void printTurns(int i)
    {
        _turns.setLabel("" + i);
        _turns.setLocation(WIDTH - PADDLE_WIDTH), (BRICK_Y_OFFSET / 2));
    }
}