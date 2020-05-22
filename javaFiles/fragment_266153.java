if (current.getDestination() instanceof PDPageDestination)
{
    PDPageDestination pd = (PDPageDestination) current.getDestination();
    System.out.println("Destination page: " + (pd.retrievePageNumber() + 1));
    return pd.getPage();
}
if (current.getAction() instanceof PDActionGoTo)
{
    PDActionGoTo gta = (PDActionGoTo) current.getAction();
    if (gta.getDestination() instanceof PDPageDestination)
    {
        PDPageDestination pd = (PDPageDestination) gta.getDestination();
        System.out.println("Destination page: " + (pd.retrievePageNumber() + 1));
        return pd.getPage();
    }
}