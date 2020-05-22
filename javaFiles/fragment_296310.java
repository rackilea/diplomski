Typeface tf = Typeface.create("cursive", Typeface.NORMAL);
for(int l=0; l<4; l++)
{
    pairs[l] = new TextView(context);
    pairs[l].setTypeface(tf);
    ...
}