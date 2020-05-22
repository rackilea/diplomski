string whereClause="";
if(yourCheckBoxPrice.Checked) 
{
    whereClause+= " AND Price BETWEEN "+ txtPriceFrom.Text + " AND "+ txtPriceTo.Text;
}

if(yourCheckBoxCamber.Checked)
{
    whereClause+= " AND Camber IN ("+ /* your list of values go here */ +")"; 
}

sql += whereClause;