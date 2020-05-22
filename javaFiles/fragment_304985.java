ArrayList<String> addAList= null;
@Override
public void onSaveInstanceState(Bundle savedInstanceState) {
   savedInstanceState.putParcelableArrayList("address", addAList);
  super.onSaveInstanceState(savedInstanceState);
}

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.your_layout);

    if(savedInstanceState!=null){
    addAList = (ArrayList<String>) savedInstanceState.getSerializable("address");
    }
    else{
        Toast msg = Toast.makeText(getApplicationContext(), "Values Not Restored!!!", Toast.LENGTH_LONG);
        msg.setGravity(Gravity.CENTER, msg.getXOffset() / 2, msg.getYOffset() / 2);
        msg.show();
        }
}