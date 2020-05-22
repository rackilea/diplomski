package com.ggl.testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CollisionGame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CollisionGame();
            }
        });
    }

    private static final int BOX_WIDTH = 640;
    private static final int BOX_HEIGHT = 480;

    public CollisionGame() {
        GameModel gameModel = new GameModel();

        JFrame frame = new JFrame("Collision");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel drawingPanel = new DrawingPanel(gameModel, BOX_WIDTH,
                BOX_HEIGHT);
        frame.add(drawingPanel);
        frame.pack();
        frame.setVisible(true);

        Animation animation = new Animation(drawingPanel, gameModel, BOX_WIDTH,
                BOX_HEIGHT);
        new Thread(animation).start();
    }

    public class DrawingPanel extends JPanel {
        private static final long serialVersionUID = -8219208002512324440L;

        private int width;
        private int height;

        private GameModel gameModel;

        public DrawingPanel(GameModel gameModel, int width, int height) {
            this.gameModel = gameModel;
            this.width = width;
            this.height = height;

            this.setFocusable(true);
            this.requestFocusInWindow();
            this.addKeyListener(new GameKeyListener(gameModel.getPlayer()));
            this.setPreferredSize(new Dimension(width, height));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, width, height);

            Player player = gameModel.getPlayer();
            g.setColor(player.getColor());
            double playerRadius = player.getRadius();
            double playerDiameter = playerRadius + playerRadius;
            g.fillOval((int) (player.getPositionX() - playerRadius),
                    (int) (player.getPositionY() - playerRadius),
                    (int) (playerDiameter), (int) (playerDiameter));

            for (Ball ball : gameModel.getBalls()) {
                g.setColor(ball.getColor());
                double ballRadius = ball.getRadius();
                double ballDiameter = ballRadius + ballRadius;
                g.fillOval((int) (ball.getPositionX() - ballRadius),
                        (int) (ball.getPositionY() - ballRadius),
                        (int) (ballDiameter), (int) (ballDiameter));
            }
        }
    }

    public class Animation implements Runnable {
        private static final long UPDATE_RATE = 30;

        private boolean running;

        private double width;
        private double height;

        private DrawingPanel drawingPanel;

        private GameModel gameModel;

        public Animation(DrawingPanel drawingPanel, GameModel gameModel,
                double width, double height) {
            this.drawingPanel = drawingPanel;
            this.gameModel = gameModel;
            this.width = width;
            this.height = height;
            this.running = true;
        }

        @Override
        public void run() {
            sleep(1000L);
            long ballTime = System.currentTimeMillis();
            long nextBallTime = 30000L;
            gameModel.addBall();

            while (running) {
                long elapsedTime = System.currentTimeMillis() - ballTime;
                if (elapsedTime >= nextBallTime) {
                    gameModel.addBall();
                    ballTime += nextBallTime;
                }

                movePlayer(gameModel.getPlayer());
                for (Ball ball : gameModel.getBalls()) {
                    moveBall(ball);
                }

                repaint();

                if (isPlayerHit()) {
                    running = false;
                } else {
                    sleep(1000L / UPDATE_RATE);
                }
            }
        }

        private void movePlayer(Player player) {
            player.setPositionX(player.getPositionX() + player.getSpeedX());
            player.setPositionY(player.getPositionY() + player.getSpeedY());

            double radius = player.getRadius();
            if (player.getPositionX() - radius < 0) {
                player.setSpeedX(-player.getSpeedX());
                player.setPositionX(radius);
            } else if (player.getPositionX() + radius > width) {
                player.setSpeedX(-player.getSpeedX());
                player.setPositionX(width - radius);
            }

            if (player.getPositionY() - radius < 0) {
                player.setSpeedY(-player.getSpeedY());
                player.setPositionY(radius);
            } else if (player.getPositionY() + radius > height) {
                player.setSpeedY(-player.getSpeedY());
                player.setPositionY(height - radius);
            }
        }

        private void moveBall(Ball ball) {
            ball.setPositionX(ball.getPositionX() + ball.getSpeedX());
            ball.setPositionY(ball.getPositionY() + ball.getSpeedY());

            double radius = ball.getRadius();
            if (ball.getPositionX() - radius < 0) {
                ball.setSpeedX(-ball.getSpeedX());
                ball.setPositionX(radius);
            } else if (ball.getPositionX() + radius > width) {
                ball.setSpeedX(-ball.getSpeedX());
                ball.setPositionX(width - radius);
            }

            if (ball.getPositionY() - radius < 0) {
                ball.setSpeedY(-ball.getSpeedY());
                ball.setPositionY(radius);
            } else if (ball.getPositionY() + radius > height) {
                ball.setSpeedY(-ball.getSpeedY());
                ball.setPositionY(height - radius);
            }
        }

        private boolean isPlayerHit() {
            Player player = gameModel.getPlayer();
            for (Ball ball : gameModel.getBalls()) {
                double radiusSquared = Math.pow(
                        ball.getRadius() + player.getRadius(), 2D);
                double distanceSquared = Math.pow(
                        (ball.getPositionX() - player.getPositionX()), 2D)
                        + Math.pow(ball.getPositionY() - player.getPositionY(),
                                2D);
                if (distanceSquared <= radiusSquared) {
                    return true;
                }
            }

            return false;
        }

        private void repaint() {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    drawingPanel.repaint();
                }
            });
        }

        private void sleep(long sleepTime) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {

            }
        }
    }

    public class GameKeyListener implements KeyListener {
        private float playerSpeedX;
        private float playerSpeedY;

        private Player player;

        public GameKeyListener(Player player) {
            this.player = player;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                playerSpeedX = 5;
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                playerSpeedX = -5;
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                playerSpeedY = -5;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                playerSpeedY = 5;
            }

            updatePlayer();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                playerSpeedX = 0;
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                playerSpeedX = 0;
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                playerSpeedY = 0;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                playerSpeedY = 0;
            }

            updatePlayer();
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        private void updatePlayer() {
            player.setSpeedX(playerSpeedX);
            player.setSpeedY(playerSpeedY);
        }

    }

    public class GameModel {
        private List<Ball> balls;
        private List<Ball> newBalls;

        private Player player;

        public GameModel() {
            this.balls = new ArrayList<>();
            this.newBalls = createBalls();
            this.player = new Player(Color.PINK, 120, 140, 20, 0, 0);
        }

        private List<Ball> createBalls() {
            List<Ball> balls = new ArrayList<>();
            balls.add(new Ball(Color.BLUE, 320, 120, 20, 7, 7));
            balls.add(new Ball(Color.RED, 600, 300, 15, -10, 10));
            balls.add(new Ball(Color.GREEN, 320, 340, 20, 10, -10));
            balls.add(new Ball(Color.YELLOW, 50, 400, 50, -3, -3));

            return balls;
        }

        public void addBall() {
            if (!newBalls.isEmpty()) {
                balls.add(newBalls.get(0));
                newBalls.remove(0);
            }
        }

        public List<Ball> getBalls() {
            return balls;
        }

        public Player getPlayer() {
            return player;
        }

    }

    public class Player {
        private float speedX;
        private float speedY;
        private double radius;
        private double positionX;
        private double positionY;
        private Color color;

        public Player(Color color, double positionX, double positionY,
                double radius, float speedX, float speedY) {
            this.color = color;
            this.positionX = positionX;
            this.positionY = positionY;
            this.radius = radius;
            this.speedX = speedX;
            this.speedY = speedY;
        }

        public float getSpeedX() {
            return speedX;
        }

        public void setSpeedX(float speedX) {
            this.speedX = speedX;
        }

        public float getSpeedY() {
            return speedY;
        }

        public void setSpeedY(float speedY) {
            this.speedY = speedY;
        }

        public double getRadius() {
            return radius;
        }

        public double getPositionX() {
            return positionX;
        }

        public void setPositionX(double positionX) {
            this.positionX = positionX;
        }

        public double getPositionY() {
            return positionY;
        }

        public void setPositionY(double positionY) {
            this.positionY = positionY;
        }

        public Color getColor() {
            return color;
        }
    }

    public class Ball {
        private float speedX;
        private float speedY;
        private double radius;
        private double positionX;
        private double positionY;
        private Color color;

        public Ball(Color color, double positionX, double positionY,
                double radius, float speedX, float speedY) {
            this.color = color;
            this.positionX = positionX;
            this.positionY = positionY;
            this.radius = radius;
            this.speedX = speedX;
            this.speedY = speedY;
        }

        public float getSpeedX() {
            return speedX;
        }

        public void setSpeedX(float speedX) {
            this.speedX = speedX;
        }

        public float getSpeedY() {
            return speedY;
        }

        public void setSpeedY(float speedY) {
            this.speedY = speedY;
        }

        public double getRadius() {
            return radius;
        }

        public double getPositionX() {
            return positionX;
        }

        public void setPositionX(double positionX) {
            this.positionX = positionX;
        }

        public double getPositionY() {
            return positionY;
        }

        public void setPositionY(double positionY) {
            this.positionY = positionY;
        }

        public Color getColor() {
            return color;
        }

    }
}