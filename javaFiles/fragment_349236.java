if (hasSkunk) {
    if (!hasThreePlayer) {
        if (redTeamScore<=90) {
            baseVictoryText += "\nAnd Red Team got Skunked";
        }
    } else {
        if ((redTeamScore <= 90) && (greenTeamScore <= 90)) {
            baseVictoryText += "\nAnd Red and Green Teams got Skunked";
        } else if (redTeamScore <= 90) {
            baseVictoryText += "\nAnd Red Team got Skunked";
        } else if (greenTeamScore <= 90) {
            baseVictoryText += "\nAnd Green Team got Skunked";
        }
    }
}
winningTeamTextView.setText(baseVictoryText);