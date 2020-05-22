Handler handler = new Handler();
handler.postDelayed(new Runnable(){ 
    public void run(){
        tobox.setText(meaning.replace("/", "\n"));
    }
}, 500); // 500 ms