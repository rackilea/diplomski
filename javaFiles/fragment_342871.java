class Table
{
    private Map<String, WoodPiece> woodPieces = new HashMap<>();

    public Table ()
    {
         // constructor
    }

    public void addWoodPiece (WoodPiece wp)
    {
         woodPieces.put(wp.getID(), wp); 
    }

    public WoodPiece removeWoodPiece (String id)
    {
         return woodPieces.remove(id);
    }
}