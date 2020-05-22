checkbox.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP){
            // check if there are already two checkboxes selected
            // you can use checkbox.isChecked() and a loop for that
            Toast.makeText(getApplicationContext(), "Only two checkboxes allowed", Toast.LENGTH_SHORT).show();
            return true; //this will prevent checkbox from changing state
        }
        return false; // this is default and lets event propagate
    }
});