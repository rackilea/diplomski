public static void ensureVisible(ListView listView, int pos)
{
if (listView == null)
{
    return;
}

if(pos < 0 || pos >= listView.getCount())
{
    return;
}

int first = listView.getFirstVisiblePosition();
int last = listView.getLastVisiblePosition();

if (pos < first)
{
    listView.setSelection(pos);
    return;
}

if (pos >= last)
 {
    listView.setSelection(1 + pos - (last - first));
    return;
 }
}