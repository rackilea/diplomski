public void onClick(View v) {
    switch(v.getId()){
        case R.id.buttonA:
            displayLetters(v.getTag()); 
            break;
        case R.id.buttonB:
            displayLetters(v.getTag());
            break;
        default:
            break;
    }
}