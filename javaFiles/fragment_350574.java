AlertDialog.Builder builder = new AlertDialog.Builder(this);
LayoutInflater inflater = this.getLayoutInflater();
View dialogView = inflater.inflate(R.layout.your_layout, null);
builder.setView(dialogView);

AlertDialog alertDialog = builder.create();
alertDialog.show();