public void setData (List<Leiheintrag> list)
{
    lendlist = list;
    this.fireTableStructureChanged();
    this.fireTableDataChanged();
}