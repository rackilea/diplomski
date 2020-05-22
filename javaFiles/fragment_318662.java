for (Iterator<Object> iter = myArrayList.iterator(), Object o;
        iter.hasNext();
        o = iter.next())
{
    if (shouldRemove(o)) {
        iter.remove();
    }
}