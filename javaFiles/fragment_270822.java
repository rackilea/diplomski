public class MyDialog extends DialogFragment
{
    private static final String KEY_AUTH = "author";
    private static final String KEY_PRICE = "price";
    private static final String KEY_YEAR = "year";
    private TextView txtauthor;
    private TextView txtprice ;
    private TextView txtyear ;


public static MyDialog newInstance(String author, String price, String year )
{
    Bundle args = new Bundle();
    args.putString(KEY_AUTH , author);
    args.putString(KEY_PRICE , price);
    args.putString(KEY_YEAR , year );

    MyDialog  d = new MyDialog ();
    d.setArguments(args);

    return d;
}

@NonNull
@Override
public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
{
    View view = LayoutInflater.from(getActivity()).inflate(R.layout.my_dialoge_layout, null);

    initTextViews(view);

    MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getContext());

    builder.setView(view);

    return builder.create();

 }


    private void initTextViews(View view)
    {

      //get views
        txtauthor= view.findViewById(R.id.txtauthor);
        txtprice = view.findViewById(R.id.txtprice );
        txtyear = view.findViewById(R.id.txtyear );
      //..and so on 

        //then set values 
        txtauthor.setText(getArguments().getString(KEY_AUTH ));
        txtprice.setText(getArguments().getString(KEY_PRICE ));
        txtyear.setText(getArguments().getString(KEY_YEAR ));
    }
}//end of  class MyDialog