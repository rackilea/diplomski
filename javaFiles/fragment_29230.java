public class CustomObject {

    Context c;
    // and some other fields here...

    public CustomObject(Context c) {
        this.c = c;
    }

    public void startActivity() {

        Intent intent = new Intent(c, SecondActivity.class);
        c.startActivity(intent);
    }

    // and some other methods here...
}