String[] itemCode12345 = itemCode123.toArray(new String[itemCode123.size()]); 
String[] itemQuan12345 = itemQuan123.toArray(new String[itemQuan123.size()]);

for(int a=0; a< t2Rows.size(); a++){
    db_data.addItem(abc+"",itemCode12345[a],itemQuan12345[a]);
}