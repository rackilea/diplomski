public class AnotherActivity extends AppCompatActivity {

private int count = 1;

List<Integer> gridArray;
private TextView myDisplayText;
@Override
protected void onCreate( Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    gridArray = new ArrayList<>();
    gridArray.add(Integer.valueOf(1));
    setContentView(R.layout.activity_prac_main);



    findViews();


}
private void findViews(){

    GridLayout gridLayout = (GridLayout)findViewById(R.id.my_grid);
    gridLayout.setColumnCount(4);
    LinearLayout linearLayout = (LinearLayout) gridLayout.findViewById(R.id.linear_view);
    linearLayout.setTag("1");
    Button myButton = (Button) linearLayout.findViewById(R.id.my_btn);
    myButton.setTag("1");
    TextView myText = (TextView) linearLayout.findViewById(R.id.my_txt);
    myText.setText("1");

    myDisplayText = (TextView) findViewById(R.id.display_txt);


    myButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            TextView txt = (TextView) view;
            myDisplayText.setText("PRESS " + txt.getTag().toString());
            if(count < 24) {

                createView();
            }
            else{
                dialogBox();
            }
        }
    });
}

private void createView(){

    LinearLayout ll = new LinearLayout(this);
    ll.setId(Integer.valueOf(R.id.new_view_id));
    ll.setTag(String.valueOf(count+1));

    Button newBtn = createButton();
    newBtn.setId(Integer.valueOf(R.id.new_btn_id));
    newBtn.setTag(String.valueOf(count+1));

    TextView txtView = createText();
    txtView.setId(Integer.valueOf(R.id.new_txt_id));
    txtView.setTag(String.valueOf(count+1));
    txtView.setText(String.valueOf(count+1));

    GridLayout gridLayout = (GridLayout)findViewById(R.id.my_grid);


   ll.addView(newBtn);
    ll.addView(txtView);
    ll.setOrientation(LinearLayout.VERTICAL);

    gridLayout.addView(ll);



        count++;

}

private Button createButton(){
    Button myBtn = new Button(this);
    myBtn.setText(R.string.button_send);
    myBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            TextView txt = (TextView) view;
            myDisplayText.setText("PRESS " + txt.getTag().toString());
            if(count < 24) {

                createView();
            }
            else{
                dialogBox();
            }
        }
    });


    return myBtn;
}
public void dialogBox() {
    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
    alertDialogBuilder.setMessage("GRID IS FULL!");
    alertDialogBuilder.setPositiveButton("DELETE",
            new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface arg0, int arg1) {
                    GridLayout gridLayout = (GridLayout)findViewById(R.id.my_grid);
                    gridLayout.removeAllViews();
                    count = 0;
                    createView();

                }
            });

    alertDialogBuilder.setNegativeButton("CANCEL",
            new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface arg0, int arg1) {

                }
            });

    AlertDialog alertDialog = alertDialogBuilder.create();
    alertDialog.show();
}
private TextView createText(){
    TextView myTxt = new TextView(this);
    myTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

    return myTxt;
}

}