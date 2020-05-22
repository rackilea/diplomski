JTable table = easypath.doctorBusiness_table;

for(int i=0; I < table.getRowCount(); i++)
{
       sumTot += Double.parseDouble(table.getValueAt(i, totC).toString());
       sumTotx += Double.parseDouble(table.getValueAt(i, xC).toString());
       sumTotl += Double.parseDouble(table.getValueAt(i, lC).toString());
       sumTote += Double.parseDouble(table.getValueAt(i, eC).toString());
       sumTots += Double.parseDouble(table.getValueAt(i, sC).toString());
}