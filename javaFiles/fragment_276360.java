protected void onBindViewHolder(@NonNull MenuHolder holder, int position, @NonNull MenuItems model) {
    String name = model.getName();
    holder.textViewName.setText(name);
    String description = model.getDescription();
    holder.textViewDescription.setText(description);
    int taxAmount = model.getTaxAmount();
    //Do what you need to do with it
}