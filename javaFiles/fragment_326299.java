Arraylist<String> al=new ArrayList<String>();
cursor cursor=db.rawquery("select NAME from REGISTRATION_TABLE orderby _id ASEC",null);
if(cursor.getcount()!=0)
{ 
 cursor.movetofirst();

 do{
  al.add(cursor.getstring(0));
  }
while(cursor.movetonext());
}