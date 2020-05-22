public MethodCaller methodCaller;
public AddressAdapter(Context context, List<Address> list,MethodCaller methodCaller) {
    this.context = context;
    this.list = list;
    this.methodCaller = methodCallerl;

}

@Override
public void onBindViewHolder(@NonNull AddressAdapter.ViewHolder holder, final int position) {
    Address address = list.get(position);

    holder.btn_deleteAddress.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Address address = list.get(position);
            final String id = address.getId();


              methodCaller .deleteAddress(id);  //ClassCastException - Error

        }
    });
}