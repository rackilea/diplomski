int [] cards = new int [52];

Field  [] fields = R.drawable.class.getDeclaredFields();

String [] names = new String[52];

for(int i=0; i<fields.length; i++)
    if(fields[i].getName().contains("card_"))
        names[i] = fields[i].getName();

Arrays.sort(names);

try
{
    for(int i=0; i<names.length; i++)
        cards[i] = R.drawable.class.getField(names[i]).getInt(null);
}
catch(Exception ex){}