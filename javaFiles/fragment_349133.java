Dialog dialog = new Dialog(context);
dialog.setContentView(R.layout.dialog_reserv_table);
Button annulerButton=(Button)dialog.findViewById(R.id.annulerReserv);
annulerButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        dialog.cancel();
    }
});
dialog.show();