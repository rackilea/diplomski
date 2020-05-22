b1.setOnClickListener( new View.OnClickListener() {
    @SuppressLint("WrongConstant")
    @Override
    public void onClick(View view) {
        textBl = "";
        textBl += "(" + quantity1 + ")" + "   " + getString( R.string.blanche_string );

        priceBl = quantity1 * 500 ;

            Intent blanche = new Intent();
            blanche.putExtra( REG_INT_TAG, priceBl);
            blanche.putExtra( REG_NAME_TAG,textBl );
            setResult(RESULT_OK,blanche);
            finish();
        }
});