boolean win = false, tie = false;
String winner = "";
while(!win && !tie){
  getInputFromUser1();
  updateBoard();
  if (win || tie) break;
  getInputFromUser2();
  updateBoard();
}

//check if win or tie and display message respectfully
displayEndMessage();
return;