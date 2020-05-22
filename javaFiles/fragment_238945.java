@Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(QuizActivity.this,MainActivity .class);
        startActivity(intent);
        finish();
    }