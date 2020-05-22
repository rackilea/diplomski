button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Random r = new Random();
            ArrayList<Integer> num = getRandomNums(6);
            editText.setText(getStringNum(num));

            Collections.sort(num);
            editText2.setText(getStringNum(num));
    });



private List<Integer> getRandomNums(final int theNumDigits) {
    Random r = new Random();
    ArrayList<Integer> num = new ArrayList<>();
    for (int i = 0; i < theNumDigits; i++) {
        int answer = r.nextInt(10) + 1;
        num.add(answer);
        }

     return num;
 }

 private String getStringNum(final List<Integer> theNumbers) {
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < theNumbers.size(); i++) {
           sb.append(num.get(i));
         }

        String toReturn = sb.toString();
        sb.setLength(0);
        return toReturn;

 }