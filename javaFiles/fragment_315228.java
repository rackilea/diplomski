Vector<String> list;
...
StringBuffer tmp = new StringBuffer();
for( int i = 0 ; i < list.size(); i++ )
{
    tmp.append( list.get(i) + "\n");
}
textArea.setText( tmp.toString() );