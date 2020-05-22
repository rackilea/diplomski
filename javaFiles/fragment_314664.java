class MyClass implements View.OnClickListener {

    @Override
    public void onClick(View v) {

        // Do something clever
    }

}

// Calling Code

MyClass listener = new MyClass();
getQuote.setOnClickListener(listener);