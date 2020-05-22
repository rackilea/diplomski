private Context context;
private TextView possesionTextView;
private int iCount;

private final Runnable r = new Runnable() {
    @Override
    public void run() {
        int poss = -1 + Integer.parseInt(possesionTextView.getText().toString());
        possesionTextView.setText(String.valueOf(poss));
        iCount++;
    }
};

public void cntDownPossesion() {
  ((Activity) context).runOnUiThread(r);
}