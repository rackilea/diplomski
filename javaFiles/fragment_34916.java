if (mediator == 10) {

    forward_button.setVisibility(View.VISIBLE);
    backk--;

    // If we go below the size of the array, add the array
    // size to loop back to the last element in the array
    if (backk < 0){
        backk += list.length;
    }
    display.setText(list[backk]);
}