public int SearchDic(final CharSequence received, final Context context) {
    Handler mHandler = new Handler();
    mHandler.postDelayed(new Runnable() {
    @Override
    public void run(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.endic.naver.com/search.nhn?query=" + received + "&searchOption=entryIdiom&preQuery=&forceRedirect="));
        context.startActivity(browserIntent);
    }}, 10);
return 0; 
}