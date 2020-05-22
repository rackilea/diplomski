@Override
public PinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_item, parent, false);

    return new PinViewHolder(itemView);
}

 @Override
public void onBindViewHolder(@NonNull PinViewHolder holder, int position) {
    Log.d("PinLog", "onBindViewHolder: Created");

    PIN current = pins.get(position);

   DecryptedPIN pin = pinUtils.DecryptPIN(current, passkey);

   holder.pinTitle.setText(pin.getTitle());
   holder.pinNumber.setText(pin.getPIN());

}