public class MainActivity extends Activity implements AddToDoFragment.OnToDoAddedListener {

private ArrayList<String> todoItems;
private ArrayAdapter<String> adapter;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if(savedInstanceState == null) {
        todoItems = new ArrayList<String>();
    } else {
        todoItems = savedInstanceState.getStringArrayList("todoItemTag");//the tag must match what the variable was saved with
    }

    FragmentManager fm = getFragmentManager();

    ToDoListFragment listToDo = new ToDoListFragment();
    listToDo = (ToDoListFragment) fm.findFragmentById(R.id.list_view_fragment);
    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
    listToDo.setListAdapter(adapter);
}

public void OnToDoAdded(String newToDo) {
    todoItems.add(newToDo);
    adapter.notifyDataSetChanged();

}

//Saving the instance by overriding this function
@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);

    outState.putStringArrayList("todoItemTag", todoItems);//it would be advised to make the tags a static final String
}