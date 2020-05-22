if (game.isGameWon()) {
    message = "You defeated the alien menace!  Congratulations!\n\n"
            + "Your score was " + game.getScore();
    String name = JOptionPane.showInputDialog(this, message, "Game Over", JOptionPane.INFORMATION_MESSAGE)
    if (name != null) {
        // Save name
    }
} else {
    message = "Oh no! The aliens have defeated you.";
    JOptionPane.showMessageDialog(this,
            message, "Game Over",
            JOptionPane.INFORMATION_MESSAGE);
}