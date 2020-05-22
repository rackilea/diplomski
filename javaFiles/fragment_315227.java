Vector<String> list;
...
String tmp = "";
for( int i = 0 ; i < list.size(); i++ )
{
   tmp = tmp + list.get(i) + "\n"; 
}
textArea.setText( tmp );