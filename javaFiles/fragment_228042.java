public class YourOtherClass {

    private Context context;

    public YourOtherClass(Context context){
        this.context = context;
    }

    private void showToast(String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}