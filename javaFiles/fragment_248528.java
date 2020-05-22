button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        LayoutInflater inflater = MainActivity.this.getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_layout, null);

        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setText(textIWantToSee);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(v);
        builder.show();

        }
    });