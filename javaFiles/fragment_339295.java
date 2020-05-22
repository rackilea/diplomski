import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class GamePlayMain {
    private static void createAndShowUI() {
        String[] players = {"John", "Bill", "Frank", "Henry"};
        GameModel model = new GameModel(players);
        GameGui gui = new GameGui(model);

        JFrame frame = new JFrame("GamePlayMain");
        frame.getContentPane().add(gui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}

class GamePlayer {
    private String name;
    private boolean myTurn = false;

    public GamePlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isMyTurn() {
        return myTurn;
    }

    public void setMyTurn(boolean myTurn) {
        this.myTurn = myTurn;
    }

    @Override
    public String toString() {
        return name;
    }
}

class GameModel {
    private String[] playerNames;
    private GamePlayer[] players;
    private int playerTurnIndex = 0;

    public GameModel(String[] playerNames) {
        this.playerNames = playerNames;
        players = new GamePlayer[playerNames.length];
        for (int i = 0; i < playerNames.length; i++) {
            players[i] = new GamePlayer(playerNames[i]);
        }
        players[0].setMyTurn(true);
    }

    public int getPlayerTurnIndex() {
        return playerTurnIndex;
    }

    public GamePlayer getCurrentPlayer() {
        return players[playerTurnIndex];
    }

    public String[] getPlayerNames() {
        return playerNames;
    }

    public void advancePlay() {
        playerTurnIndex++;
        playerTurnIndex %= players.length;
        for (GamePlayer player : players) {
            if (player != getCurrentPlayer()) {
                player.setMyTurn(false);
            } else {
                player.setMyTurn(true);
            }
        }
    }

    public int getPlayerCount() {
        return players.length;
    }

    public GamePlayer getPlayer(int i) {
        return players[i];
    }

}

@SuppressWarnings("serial")
class GameGui extends JPanel {
    private GameModel gameModel;
    private JTextArea textArea = new JTextArea(14, 30);
    private Map<GamePlayer, JButton> playerButtonMap = new HashMap<GamePlayer, JButton>();

    public GameGui(GameModel gameModel) {
        this.gameModel = gameModel;

        JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));
        for (int i = 0; i < gameModel.getPlayerCount(); i++) {
            GamePlayer player = gameModel.getPlayer(i);
            JButton playerButton = new JButton(player.getName());
            playerButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    playerButtonActionPerformed(e);
                }
            });
            buttonPanel.add(playerButton);
            playerButtonMap.put(player, playerButton);
        }

        textArea.setEditable(false);
        textArea.setFocusable(false);

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout(5, 5));
        add(buttonPanel, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);

        enablePlayerTurns();
    }

    private void playerButtonActionPerformed(ActionEvent e) {
        GamePlayer currentPlayer = gameModel.getCurrentPlayer();

        // TODO: have player "play"
        textArea.append("Player " + currentPlayer + " has just played\n");
        gameModel.advancePlay();
        enablePlayerTurns();

        currentPlayer = gameModel.getCurrentPlayer();
        textArea.append("It is now player " + currentPlayer + "'s turn\n");
    }

    private void enablePlayerTurns() {
        for (int i = 0; i < gameModel.getPlayerCount(); i++) {
            GamePlayer player = gameModel.getPlayer(i);
            JButton playerButton = playerButtonMap.get(player);
            playerButton.setEnabled(player.isMyTurn());
            if (player.isMyTurn()) {
                playerButton.requestFocusInWindow();
            }
        }
    }

}