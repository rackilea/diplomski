btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        int filledFileds = countFilledFields();
        Log.d("filled", String.valueOf(filledFileds));
        Class newClass = MainActivity.class;

        switch (filledFileds){
            ...
        }

        Intent intent = new Intent(MainActivity.this, newClass);
    }