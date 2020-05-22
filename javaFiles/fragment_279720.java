public class DialogCaller {

    public static void showDialog(Context context,String title,String message,
                                  DialogInterface.OnClickListener onClickListener) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setPositiveButton("Ok",onClickListener);
        dialog.show();
    }
}