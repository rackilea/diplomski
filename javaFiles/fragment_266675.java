homeButton.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {

            Intent intent = new Intent( _context, MainMenuActivity.class );
            intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            _context.startActivity( intent );

            finish();       

            overridePendingTransition(R.anim.slide_right,R.anim.slide_right);
    }
});