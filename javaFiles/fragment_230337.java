btn.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v) {

        String items = itemList.getText().toString();
        String[] subStrings = items.split("\n"); //split your String at every new line
        String pickedItem;
        strings.clear();
        for(String s : subStrings){ //run through all substrings to add them to the list
            strings.add(s);
        }
        randomGenerator = new Random();
        int index = randomGenerator.nextInt(strings.size());
        pickedItem=strings.get(index);

        myTextView.setText("Result: \n" + pickedItem);
    }
});