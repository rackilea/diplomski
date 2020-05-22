public class MyActivity extends Activity implements MyTaskFragment.TaskCallbacks {
    private MyTaskFragment task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_layout);

        FragmentManager fm = getFragmentManager();
        task = (MyTaskFragment) fm.findFragmentByTag("myTask");

        if (task == null) {
            task = new MyTaskFragment();
            fm.beginTransaction().add(task, "myTask").commit();
        }
    }

    @Override
    public void onPreExecute() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("myDialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        StringProgressDialogFragment dialog = StringProgressDialogFragment.newInstance("My message");
        dialog.show(ft, "myDialog");
    }

    @Override
    public void onPostExecute() {
        StringProgressDialogFragment dialog = (StringProgressDialogFragment) getFragmentManager().findFragmentByTag("myDialog");
        if (dialog!=null) {
            dialog.dismiss();
        }
        // update UI
    }

    // ... other code
}