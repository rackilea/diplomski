function savetheChanges()
{
    var quantity = new array[];
    for(var i=0;i<16;i++)
    {
        quantity[i]=document.getElementById("quantity"+i).value;
     }
     document.detailsview.action ="BillCB.jsp?method=" + "17" + "&billno=" +billno+ "&quantity="+quantity;
}