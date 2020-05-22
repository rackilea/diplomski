@Override
public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
    // ...

    viewHolder.btnAdd.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showAlertDialog(view.getContext()); // pass the context here
        }
    } );
}

private void showAlertDialog(Context context) { // receive the context here
    AlertDialog.Builder builder = new AlertDialog.Builder(context); // use the context here
}