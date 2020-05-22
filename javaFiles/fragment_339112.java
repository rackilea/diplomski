String SQLupdate = "UPDATE tableItem SET ItemCount= ? WHERE ItemCode = ?";
ps = con.prepareStatement(SQLupdate);

for(int row=0; row<rows; row++) 
{
    String itemCode = (String)tabelDetailDO.getValueAt(row, 0);
    itemCount = (int) tabelDetailDO.getValueAt(row, 2);
    addItemCount = (int) tabelDetailDO.getValueAt(row, 3);
    totalItemCount = itemCount + addItemCount;
    ps.setInt(1, totalItemCount);
    ps.setString(2, itemCode);
    ps.addBatch();
}