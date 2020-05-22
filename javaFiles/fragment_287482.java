switch (view.getId()){
    case R.id.ten:
        startNewGame();
        return;
    case R.id.eleven:
        MainActivity.this.finish();
        return;
}

if(!mGameOver){
    // The rest of your ButtonClickListener click logic as you have it now