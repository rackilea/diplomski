public void SaveDataOnClick (View view){
  Name = TextName.getText().toString();
  Score = Integer.parseInt(TextScore.getText().toString());
  System.out.println(Name);
  System.out.println(Score);
}