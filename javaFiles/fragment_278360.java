public class ElementAdapter extends PagerAdapter {

    private ArrayList<Element> element = new ArrayList<Element>();
    private Context ctx;

    public ElementAdapter(ArrayList<Element> element, Context ctx) {
        this.element = element;
        this.ctx = ctx;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Use ViewGroup
        ViewGroup item_view = (ViewGroup) inflater.inflate(R.layout.element, container ,false);

        TextView nome = (TextView) item_view.findViewById(R.id.nome);
        TextView surname= (TextView) item_view.findViewById(R.id.surname);

        nome.setText(element.get(position).getNome());
        surname.setText(element.get(position).getSurname());

        container.addView(item_view);

        return item_view;
    }

    @Override
    public int getCount() {
        return this.element.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object view) {

        // Remove specific view
        container.removeView((View) view);
    }
}