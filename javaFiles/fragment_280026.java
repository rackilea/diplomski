char eng=jTextField1.getText().charAt(0);
ArrayList<Character> list=new ArrayList<Character>();
list.add('a');
list.add('e');
list.add('i');
list.add('o');
list.add('u');
list.add('y');
if(list.contains(eng)){
    jTextField2.setText("It is a vowel");
}else{
    jTextField2.setText("It is not a vowel");
}