public View getView(final int position, View view, ViewGroup parent) {
    LayoutInflater inflater = context.getLayoutInflater();
    View rowView = inflater.inflate(R.layout.listview_row,null,true);

    //this code gets references to objects in the listview_row.xml file
    TextView txtQtd,txtName;
    txtQtd = (TextView) rowView.findViewById(R.id.txtQtd);
    txtName = (TextView) rowView.findViewById(R.id.txtName);
    final ImageButton btnAddTransaction = (ImageButton) rowView.findViewById(R.id.btnAddTransaction);

    //this code sets the values of the objects to values from the arrays

    Equipamento equipamento = equipamentos.get(position);

    txtQtd.setText(String.valueOf(equipamento.getId()));
    txtName.setText(String.valueOf(equipamento.getQuantidade()));

    btnAddTransaction.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Equipamento equipamento = equipamentos.get(position);
        callDialogTransaction(equipamento);
        Animation animation = new AlphaAnimation(1.0f,0.8f);
        animation.setDuration(100);
        btnAddTransaction.startAnimation(animation);
    }
});
    return rowView;