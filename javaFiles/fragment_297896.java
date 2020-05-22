for (BaseColumn col : list)
{
    if (col instanceof Column)
    {
        Cell detailCell = ((Column) col).getDetailCell();
        JRDesignFrame frame = (JRDesignFrame) detailCell.getElements()[0];
        ...
    }
}