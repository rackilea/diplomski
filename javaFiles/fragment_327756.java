btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        int filledFileds = countFilledFields();
        Log.d("filled", String.valueOf(filledFileds));
        Class newClass = null;

        switch (filledFileds){
            ...
        }

        if (newClass != null) {
            Intent intent = new Intent(MainActivity.this, newClass);
            startActivity(intent);
        }
    }