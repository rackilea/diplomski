public class KeyAction extends AbstractAction
{
    private static final long serialVersionUID = 1L;
    public char theLetter;
    public String theCommand;
    public enum KeyType {CHARACTER_ENTRY, KEYSTROKE_COMMAND};
    public final KeyType actionType;

    public KeyAction(char letter)
    {
        theLetter = letter;
        actionType = KeyType.CHARACTER_ENTRY;
    }

    public KeyAction(String command)
    {
        theCommand = command;
        actionType = KeyType.KEYSTROKE_COMMAND;
    }


    public void actionPerformed(ActionEvent ae)
    {
        if(actionType == KeyType.CHARACTER_ENTRY) {
            System.out.print(theLetter);
            editor.receiveKey(theLetter);
        }
        else {
            System.out.println("\n" + theCommand);
            editor.receiveCommand(theCommand);
        }

    }
}