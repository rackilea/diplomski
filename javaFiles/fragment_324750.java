int count=cursor.getCount();
 nameArr=new String[count];
 addressArr=new String[count];
 contactArr=new String[count];
 int index_count=0;
while(!(cursor.isAfterLast())){
    nameArr[index_count]=cursor.getString(1); 
    addressArr[index_count]=cursor.getString(2);
    contactArr[index_count]=cursor.getString(3);
    index_count++;
    cursor.moveToNext();
}