final RadioGroup rd = (RadioGroup) 
convertView.findViewById(R.id.RadioGroup);
rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (getItem(position).getAnswer() == rd.getCheckedRadioButtonId()) {
                isCorrectAnswer[position] = true;
        } else { 
                isCorrectAnswer[position] = false;
    }

});