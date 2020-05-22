// Turns out that when the layout is not a TextView, you need to provide the id
// of the TextView the adapter can bind to
ArrayAdapter<Customer> customerAdapter = new ArrayAdapter<Customer>(this,
        R.layout.list_item, R.id.customer_name, customerList) {
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        TextView name = view.findViewById(R.id.customer_name);
        TextView surname = view.findViewById(R.id.customer_surname);

        name.setText(getItem(position).customerName);
        surname.setText(getItem(position).customerSurname);

        return view;
    }
};