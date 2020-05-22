public boolean isCellsSelectable()
{
    if (model.isEdge())
    {
        return false;
    }

    return cellsSelectable;
}