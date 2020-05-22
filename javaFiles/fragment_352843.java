public class ButtonCreator
{
    private Facts facts;
    public ButtonCreator( Facts facts )
    {
        this.facts = facts;
    }

    public boolean canCreateNextButton() { return facts.hasNext(); }
    public boolean canCreatePreviousButton() { return facts.hasPrevious(); }
    public Button createNextButton( Context context )
    {
        Button button = new Button( context );
        button.setText( facts.next() );
        return button;
    }
    public Button createPreviousButton( Context context )
    {
        Button button = new Button( context );
        button.setText( facts.previous() );
        return button;
    }
}