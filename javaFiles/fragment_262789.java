public class Adapter extends PagerAdapter {

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    private SetupActivity setupActivity;

    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
        setupActivity = (SetupActivity) context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        final View view = layoutInflater.inflate(R.layout.item, container, false);

        TextView buttonDeleteCard = view.findViewById(R.id.textViewDeleteCard);

        buttonDeleteCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupActivity.deleteSession([...some title...]);
                setupActivity.refreshAdapter();
            }
        });

        container.addView(view, 0);
        return view;
    }
}