if(data ! = null) {
    //means you have parsed XML to string array
    if(current != data.length) {
        //means there is some data that user did not viewd
        youTextView.setText(data[current]);
        current++;
    }
}