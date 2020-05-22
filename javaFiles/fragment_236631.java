TV=(TextView)view.findViewById(R.id.textView);
if (condition())
{
    TV.setText(Html.fromHtml("<b>TEXT 01 </b>"));
else
{
    TV.setText(Html.fromHtml("<b>TEXT 02</b>"));
}

if (condition)
{
    TV.append(Html.fromHtml("TEXT 03"));
}
else
{
    TV.append(Html.fromHtml("TEXT 04"));
}