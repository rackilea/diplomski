public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shop);

    initialize_PR();
    display_PR();
    BuyDialog=new BuyDialogClass(this);
    //The setContentView is not necessary here as we call it on the onCreate

    //We can NOT access Dialog widgets from here,
    //because the dialog has not yet been shown.

}
public void Action_ShowDialog_Buy(View view) {
    BuyDialog.show() ;

    //NOW, after showing the dialog, we can access its widgets
    jobject_SeekBar_buy= (SeekBar) BuyDialog.findViewById(R.id.SeekBar_Dialog_Buy) ;
    jobject_SeekBar_buy.setMax(PR_num_coins/currentPR_buy_price) ;
    jobject_SeekBar_buy.setOnSeekBarChangeListener(this);

}
public void Action_Buy_PR(View view) {
    BuyDialog.dismiss() ;
}