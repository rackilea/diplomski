public abstract class BaseActivity {

    //....
    public void openNewView(Class viewClass) {
        Intent intent = new Intent(this, viewClass.class);
        startActivity(intent);
    }
}