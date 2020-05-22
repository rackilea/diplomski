ps.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        Intent it = new Intent("com.example.phone.PhoneStatus");
        ps.getContext().startActivity(it);
    }
});