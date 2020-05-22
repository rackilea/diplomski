String[] items = new String[] { "item 1", "item 2", "item 3" };
CharSequence allText = "";
for (int i = 0; i < items.length; i++)
{
    String text = items[i];
    SpannableString s = new SpannableString(text + "\n");
    s.setSpan(new BulletSpan(BulletSpan.STANDARD_GAP_WIDTH), 0, text.length(), 0);          
    allText = TextUtils.concat(allText, s);         
}