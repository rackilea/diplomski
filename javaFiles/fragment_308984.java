cb1=new JComboBox();
for(int i=1;i<=31;i++)
{
    if(i<10)
    {
        cb1.addItem("0"+i);
    }
    else
    {
        cb1.addItem(Integer.toString(i));
    }
}