public void displayNode()
{
    LinkLL current = firstNode;

    while (current != null)
    {
        l.showName();
        current = current.rightConnector;
    }       
}