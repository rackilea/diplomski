public class PhoneView extends LinearLayout {

    private TextView numberView;
    private ImageView phoneIcon;

    public PhoneView(Context context) {this(context, null);}
    public PhoneView(Context context, AttributeSet attrs) {this(context, attrs, 0);}
    public PhoneView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        setOrientation(HORIZONTAL);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.view_phone, this, true);

        numberView = (TextView) view.findViewById(R.id.contact_number);
        phoneIcon = (ImageView) view.findViewById(R.id.phone_icon);

        phoneIcon.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                callNumber();
            }
        });
    }

    public void setContactNumber(String number) {
        numberView.setText(number);
    }

    private void callNumber() {
        //...
    }
}