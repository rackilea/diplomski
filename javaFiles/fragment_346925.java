private void helperMethodName (Button buttonNo, Button buttonYes){
    buttonNo.setTextColor(getApplication().getResources().getColor(R.color.colorAccent));
    buttonNo.setBackground(getDrawable(R.drawable.button_background));
    buttonYes.setTextColor(getApplication().getResources().getColor(R.color.black));
    buttonYes.setBackground(getDrawable(R.drawable.inactive_button_background));

    if (one != 0 && two != 0 && three != 0 && fore != 0) {
        nextstep.setEnabled(true);
    }
}