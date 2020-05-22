private View getCustomView(LayoutInflater inflater, int tipo, List<String[]> data, int pos) {
    // Inflate
    View view = inflater.inflate(R.layout.item_obs_carrinho, null);
    view.setLayoutParams(
            new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

    // Remove parent
    if (view.getParent() != null)
        ((ViewGroup) view.getParent()).removeView(view);

    // Find Views
    TextView n = (TextView) view.findViewById(R.id.item_ingred_carrinho);
    TextView qtd = (TextView) view.findViewById(R.id.quantidade);

    // Set views based on type
    if (tipo == 2 || tipo == 3) { // add
        n.setText(data.get(0)[pos]);
        qtd.setText(data.get(1)[pos]);
    } else if (tipo == 1 || tipo == 3) { // rem
        n.setText(data.get(0)[pos]);
        qtd.setText("");
        ImageView add = (ImageView) view.findViewById(R.id.add_ou_rem);
        add.setImageResource(android.R.drawable.ic_delete);
    }
    return view;
}