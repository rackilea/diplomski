List<CheckBox> list = new LinkedList<>(); //this should be visible from onClickListener, so it should be an instance field

for (String answer : multiMap.get(questionFromMultiMap)) {
        i++;
        CheckBox et_button = (CheckBox) getLayoutInflater().inflate(R.layout.numberofchoices, null);
        et_button.setText(answer);
        et_button.setId(i);
        list.add(et_button);
        container.addView(et_button);
        listOfChoice.add(answer);
    }

btnCorrect.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      for(CheckBox cb : list) {
         if (cb.isChecked()){
             System.out.println(cb.getId());
         }else{
             System.out.println("pouet");
         }
      }
    }
});