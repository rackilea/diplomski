ArrayList<Integer> sun32A = new ArrayList<Integer>(); <---- Variable moved to outside of method.

private void sun32() {

    if (sun32A.contains(sonyR)) {
        // removed irrelevant code line
        tvSony.setText(String.valueOf(sonyR)); <----- Convert the int to String before setting text.

    } else {
        int myInt = Integer.valueOf(tvSony.getText().toString()); <----- fixed code 
        sun32A.add(myInt);
    }
    return;
}