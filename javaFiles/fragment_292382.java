// below makes S-M-T-W-T-F and green fill
for (int i = 0; i <= weekDays.length - 1; i++) {
    Label daysOfWeek = createLabel(weekDays[i]);
    grid.add(daysOfWeek, i, 0);
    daysOfWeek.setStyle("-fx-text-fill: white;"
            + "-fx-background-color: green;" + "-fx-border-color: black;" + "-fx-border-width: 1 1 0 0;");

}// end for loop to cycle through days of week

final String otherMonthStyle = "-fx-text-fill: white;-fx-border-color: black;-fx-background-color: grey;-fx-border-width: 1 1 0 0;";

//below are the days of the month 
for (int i = 1; i <= FRAMES; i++) {
    int yPos = ((i - 1) / 7) + 1;
    int xPos = (i - 1) % 7;

    if (i < 32) {
        Label monthDays = createLabel(String.valueOf(i));
        grid.add(monthDays, xPos, yPos);

        monthDays.setStyle("-fx-border-color: black;-fx-border-width: 1 1 0 0;");

    } else if (i > 32) {
        // below creating november labels days 1 -- 4
        Label nov1 = createLabel("1");
        grid.add(nov1, 3, 5);
        Label nov2 = createLabel("2");
        grid.add(nov2, 4, 5);
        Label nov3 = createLabel("3");
        grid.add(nov3, 5, 5);
        Label nov4 = createLabel("4");
        grid.add(nov4, 6, 5);

        // below padding and making borders for labels
        nov1.setStyle(otherMonthStyle);
        nov2.setStyle(otherMonthStyle);
        nov3.setStyle(otherMonthStyle);
        nov4.setStyle(otherMonthStyle);
    }

}// end for loop to cycle through days of month 

grid.setStyle("-fx-border-color: black;" + "-fx-border-width: 0 0 1 1;");

StackPane gridWrapper = new StackPane(grid);
gridWrapper.setPadding(new Insets(20));