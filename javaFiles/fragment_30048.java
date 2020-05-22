Border b;
String title;

b = c.getBorder();
if(b instanceof TitledBorder)
{
    title = ( (TitledBorder)b ).getTitle();
}