public void onButtonPlayClicked(View v) throws Exception {
    Log.i("MESSAGE", "Play");
    try {  
        this.activity.binding.getViewModel().play(this.activity.binding.editTurn.getText().toString());
    } catch (Exception ex) {
        Log.i("EXCEPTION", "");
    }
}