@Override
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
{
    super.onCreateContextMenu(menu, v, menuInfo);
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.optmenu, menu);
}

@Override
public boolean onContextItemSelected(MenuItem item)
{
    AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
    switch(item.getItemId())
    {
        case R.id.item3:
            RemoveTask(info.position);
            break;
    }

    return true;
}