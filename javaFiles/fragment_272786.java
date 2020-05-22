for (int x = 1; x <= 4; x++) {
    Button button = new Button(this);  

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // code    
        }
    });

    list.add(button);
    layout.addView(button);
}