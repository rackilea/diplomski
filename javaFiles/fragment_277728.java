public void refresh()
    {
        cursor = getCursor();
        adapter = new testAdapter(context, cursor);

        setListAdapter(adapter);
}