public class MyListActivity extends ListActivity implements OnItemClickListener
{
    @Override
    public void onItemClick(AdapterView<?> parent, View v, int position, long id)
    {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EMService.INTENT_EXTRA_DETAIL_VIEW_SOMEPARAM, 0);
        startActivityForResult(intent, 0);
    }

}