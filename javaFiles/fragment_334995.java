package components;
        import java.awt.*;
        import static java.awt.BorderLayout.NORTH;
        import static java.awt.BorderLayout.SOUTH;
        import java.awt.event.*;
        import static java.lang.Integer.parseInt;
        import javax.swing.*;
        import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
        import javax.swing.event.MouseInputAdapter;

        public class ChessBoard //implements MouseListener, MouseMotionListener
        {
          static Point parentLocation;
          int homeRow, homeCol; // where to restore moved user letter if dropped on occupied cell

          static int    N     = 11; // NxN 'chessboard' squares
          static int    S     = 44; // square dimensions: SxS 
          static int    W         ; // chessboard dimensions: WxW 
          static int    USER7 = 7;
          static Font   dragFont;
          static JFrame frame;
          JLayeredPane  layeredPane;
          static JPanel gamePanel, // encompasses both pnlGrid and pnlUser
                        pnlGrid, 
                        pnlUser;
          JLabel        userDragLetter = new JLabel(); // main item to drag around or restore if needed
          int           xAdjustment, yAdjustment; // how to locate drops accurately

          String userLetters[] ;

          public ChessBoard() // constructor
          {
            W = S*N;
            dragFont = new Font("Courier", Font.PLAIN, S);

            userLetters = new String[USER7];
            for (int i = 0; i < USER7; i++)
              userLetters[i] = "" + (char)(65 + Math.random()*26);

            Dimension gridSize  = new Dimension(W,  W);  
            Dimension userSize  = new Dimension(W,      S);
            Dimension gameSize  = new Dimension(W, (W + S));

            frame               = new JFrame();
            frame.setSize(new Dimension(gameSize)); // DO NOT USE PREFERRED

            layeredPane = new JLayeredPane();
            layeredPane.setPreferredSize( gameSize ); // NO PREFERRED => NO GRID!

            gamePanel   = new JPanel();

// **EDIT** LOSE THIS LINE            gamePanel.setLayout(new BorderLayout());

            gamePanel.setPreferredSize(gameSize);

            pnlGrid     = new JPanel();
            pnlGrid.setLayout(new GridLayout(N, N));
            pnlGrid.setPreferredSize( gridSize );
            pnlGrid.setBounds(0, 0, gridSize.width, gridSize.height);

            pnlUser     = new JPanel();
            pnlUser.setLayout(new GridLayout(1, N));
            pnlUser.setPreferredSize(userSize);
            pnlUser.setBounds(0, gridSize.height, userSize.width, userSize.height);

            layeredPane.add(pnlGrid, JLayeredPane.DEFAULT_LAYER); // panels to drag over
            layeredPane.add(pnlUser, JLayeredPane.DEFAULT_LAYER); //  "         "

            for (int i = 0; i < N; i++){
              for (int j = 0; j < N; j++){
                JPanel square = new JPanel();
                square.setBackground( (i + j) % 2 == 0 ? Color.red : Color.white );
                pnlGrid.add( square );
              }
            }

            for (int i = 0; i < N; i++) {
              JPanel square = new JPanel(new BorderLayout());
              square.setBackground(Color.YELLOW);
              pnlUser.add(square);
            }

            for (int i = 0; i < USER7; i++)
              addPiece(i, 0, userLetters[i]);

            gamePanel.addMouseListener(new MouseInputAdapter()
            {
              public void mousePressed (MouseEvent e){mousePressedActionPerformed (e);}
              public void mouseReleased(MouseEvent e){mouseReleasedActionPerformed(e);}
            });

            gamePanel.addMouseMotionListener(new MouseMotionAdapter()
            {
              public void mouseDragged(MouseEvent me){mouseDraggedActionPerformed(me);}
            });

    // **EDIT: LOSE THE NEXT TWO LINES AND REPLACE BY THE LINE AFTER THEM** 


        //        gamePanel.add(layeredPane, NORTH);
        //        gamePanel.add(pnlUser,     SOUTH);
                 gamePanel.add(layeredPane);
              }

          private void addPiece(int col, int row, String glyph) {
            JLabel piece = new JLabel(glyph, JLabel.CENTER);
            piece.setFont(dragFont);
            JPanel panel = (JPanel) pnlUser.getComponent(col + row * N);
            piece.setName("piece " + glyph + " @ " + row + " " + col);
            panel.add(piece);
          }

          void mousePressedActionPerformed(MouseEvent e)
          {
            userDragLetter = null; // signal that we're not dragging if no piece is in the square

            gamePanel.setCursor(new Cursor(Cursor.HAND_CURSOR));

            Component c =  pnlGrid.findComponentAt(e.getX(), e.getY());
            if(c != null)
              return; // Illegal to click pnlGrid

            c =  pnlUser.findComponentAt(e.getX(), e.getY() - pnlGrid.getHeight()); 

            if(c ==  null | c instanceof JPanel)
              return; // letter already played; can't drag empty cell

            parentLocation = c.getParent().getLocation();
            xAdjustment = parentLocation.x - e.getX(); 
            yAdjustment = parentLocation.y - e.getY() + gamePanel.getHeight() - pnlUser.getHeight();

            userDragLetter = (JLabel)c;
            userDragLetter.setPreferredSize(new Dimension(S, S)); // prevent 2 letters in a square
            userDragLetter.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);

            layeredPane.add(userDragLetter, JLayeredPane.DRAG_LAYER);

            homeRow = parseInt(userDragLetter.getName().substring(10,11)); // save restore location 
            homeCol = parseInt(userDragLetter.getName().substring(12,13));
          }

          void mouseDraggedActionPerformed(MouseEvent me)
          {
            if (userDragLetter == null)
              return; // nothing to drag

            int x = me.getX() + xAdjustment; // make sure grid cell will be chosen in-bounds
            int xMax = layeredPane.getWidth() - userDragLetter.getWidth();
            x = Math.min(x, xMax);
            x = Math.max(x, 0);

            int y = me.getY() + yAdjustment;
            int yMax = layeredPane.getHeight() - userDragLetter.getHeight();
            y = Math.min(y, yMax);
            y = Math.max(y, 0);

            if(y >= pnlGrid.getHeight())
              return; // can't drag to location off grid

            userDragLetter.setLocation(x, y); 
          }

          void mouseReleasedActionPerformed(MouseEvent e)
          {

    //**EDIT: CHANGED NEXT LINE**

             gamePanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            if (userDragLetter == null) 
              return; // nothing to drag; nothing to release

            //  Make sure the chess piece is no longer painted on the layered pane
            userDragLetter.setVisible(false);
            layeredPane.remove(userDragLetter);
            userDragLetter.setVisible(true);

            int xMax = layeredPane.getWidth() - userDragLetter.getWidth();
            int x = Math.min(e.getX(), xMax);
            x = Math.max(x, 0);

            int yMax = layeredPane.getHeight()- userDragLetter.getHeight();
            int y = Math.min(e.getY(), yMax);
            y = Math.max(y, 0);

            Component c =  pnlGrid.findComponentAt(x, y); // find deepest nested child component

            if(c == null) // then grid cell is unoccupied so ...
              c = pnlUser.findComponentAt(x, y); // see if there's a letter there ...

            if(c == null | (c instanceof JLabel)){ // and if illegal or there is one, put it back...
              userDragLetter.setLocation(parentLocation.x + xAdjustment, 
                                         parentLocation.y + yAdjustment + gamePanel.getHeight());
              userDragLetter.setVisible(true);
              addPiece(homeCol, homeRow,userDragLetter.getName().substring(6,7));
              layeredPane.remove(userDragLetter);
              return;
            }
            else // but if NO letter ...
            {
              Container parent = (Container)c;
              parent.add( userDragLetter );  // put one in the grid cell
              parent.validate();
            }
            userDragLetter.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
          }

          public static void main(String[] args)
          {
            new ChessBoard();
            frame.add(gamePanel);
            frame.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        //    frame.setResizable( false );
            frame.pack();
            frame.setLocationRelativeTo( null );
            frame.setVisible(true);
          }
        }