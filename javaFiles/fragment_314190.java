public class ViewDialog {
public void showDialog(View activity,int width,int height){
    final Dialog dialog = new Dialog(activity.getContext());
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    dialog.setCancelable(false);
    dialog.setContentView(R.layout.custom_dialog);

    ImageView dialogButton = (ImageView) dialog.findViewById(R.id.okay);
    dialogButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.dismiss();
        }
    });

    dialog.show();
    Window window = dialog.getWindow();

    window.setLayout(width, height);

}
}