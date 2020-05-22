@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
    String [] a={"haha"};
    savedInstanceState.putStringArray("MyStringarray", a);
    super.onSaveInstanceState(savedInstanceState);
    Toast.makeText(context, "Saved array", Toast.LENGTH_SHORT).show();
}