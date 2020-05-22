public class ListViewHolder extends ViewHolder {

    @Override
    public View getView(View view) {
        Holder holder;

        if (view == null) {
            view = LayoutInflater.from(contextProvider.get()).inflate(R.layout.entry, null);
            // getHolder looks like this:
            // @Inject
            // private Provider<Holder> holderProvider;
            // public Holder getHolder() {
            //     holderProvider.get();
            // }
            holder = getHolder();

            holder.text = (TextView) view.findViewById(R.id.textView1);

            view.setTag(viewStructure);
        } else {
            holder = (DualTextViewStructure) view.getTag();
        }

        holder.text.setText(/* Date */);

        return view;
    }
}