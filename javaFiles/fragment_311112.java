position++;
Names names1 = namesList.get(position);

if (position < namesList.size() ){
    nameEnglish.setText(names1.getName());
    arabicTxt.setText(names1.getArabicName());
    txtMeaning.setText(names1.getMeaning());
}