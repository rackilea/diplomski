questionPanel = new VBox();

for(int i = 0; i < optionsButton.length; i++)
{

 optionsButton[i] = new RadioButton(questions[currQuestion].getOption(i));
 optionsButton[i].setToggleGroup(bG);
 questionPanel.getChildren().add(optionsButton[i]);


}