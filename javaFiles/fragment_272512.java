class MyListener extends OnClickListener {
    public void onClick(View v) {
        // my onClick code goes here
    }
}

MyListener foo = new MyListener();

button.setOnClickListener(foo);