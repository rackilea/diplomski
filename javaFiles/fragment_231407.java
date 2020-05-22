public final List<String> messages = new LinkedList<String>();

public void changeMessages()
{
    messages = new ArrayList<String>();  // can't change a final variable
}