public class TicTacToeListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        // game logic here
    }
}

public class ticTacToe implements ActionListener {
    public void actionPerformed(ActionEvent actionEvent) {
        instruct.addActionListener(new TickTacToeListener);
        System.out.println(actionEvent.getActionCommand());
    }
}