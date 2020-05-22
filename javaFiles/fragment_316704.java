StackPane stack = new StackPane();
Rectangle helpIcon = new Rectangle(35.0, 25.0);
helpIcon.setFill(new LinearGradient(0,0,0,1, true, CycleMethod.NO_CYCLE,
new Stop[]{
new Stop(0,Color.web("#4977A3")),
new Stop(0.5, Color.web("#B0C6DA")),
new Stop(1,Color.web("#9CB6CF")),}));
helpIcon.setStroke(Color.web("#D0E6FA"));
helpIcon.setArcHeight(3.5);
helpIcon.setArcWidth(3.5);

Text helpText = new Text("?   ");
helpText.setFont(Font.font("Amble Cn", FontWeight.BOLD, 18));
helpText.setFill(Color.WHITE);
helpText.setStroke(Color.web("#7080A0")); 

stack.getChildren().addAll(helpIcon, helpText);
stack.setAlignment(Pos.CENTER_RIGHT);     // Right-justify nodes in stack

HBox.setHgrow(stack, Priority.ALWAYS);    // Give stack any extra space
hbox.getChildren().add(stack);            // Add to HBox from Example 1-2