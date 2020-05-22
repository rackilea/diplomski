public void flashButton(){
    runOnUiThread(new Runnable() {
            @Override
            public void run() {
                beatPrompt.setBackgroundColor(getResources().getColor(R.color.primary1transparent_very));
            }
        });
}