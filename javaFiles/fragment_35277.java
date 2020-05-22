private void disconnect() 
{   
    if (parent != null)
    {
        parent.disconnectChild(this);
        parent = null;
    }

}