//importing java swing and awt to help program work
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


    public class assignment1 extends JFrame implements ActionListener  {

            //declaring the JPanel, JLabel and JButton's Globally
            JPanel board, buttons;

            JLabel grid1, grid2, grid3, grid4;

            JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;

            //Declaring images globally
            ImageIcon pawn = new ImageIcon("Images/pawn.png");
            ImageIcon arrow1 = new ImageIcon("Images/left_up.png");
            ImageIcon arrow2 = new ImageIcon("Images/up.png");
            ImageIcon arrow3 = new ImageIcon("Images/right_up.png");
            ImageIcon arrow4 = new ImageIcon("Images/left.png");
            ImageIcon arrow5 = new ImageIcon("Images/reset.png");
            ImageIcon arrow6 = new ImageIcon("Images/right.png");
            ImageIcon arrow7 = new ImageIcon("Images/left_down.png");
            ImageIcon arrow8 = new ImageIcon("Images/down.png");
            ImageIcon arrow9 = new ImageIcon("Images/right_down.png");

        public static void main(String[]args){

            assignment1 frame = new assignment1();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        public assignment1() {

            super("Chess Board");

                    Container c = getContentPane();
                    c.setLayout(new GridLayout (2,2));

                //setting up new JPanel for board to display the 4 grids
                board = new JPanel();
                board.setLayout(new GridLayout(2,2,4,4));
                JPanel buttons = new JPanel();
                buttons.setLayout(new GridLayout(3,3,2,2));

                //setting up grid1
                grid1 = new JLabel(pawn);//placing the image in the background of the grid
                grid1.setBackground(Color.white);
                grid1.setOpaque(true);
                grid1.setIcon(pawn);//displaying image

                //adding grid1 to the board
                board.add(grid1);

                //setting up grid2
                grid2 = new JLabel(pawn);//placing the image in the background of the grid
                grid2.setBackground(Color.black);
                grid2.setOpaque(true);
                grid2.setIcon(null);//setting icon to null

                //adding grid2 to the board
                board.add(grid2);

                //setting up grid3
                grid3 =  new JLabel(pawn);//placing the image in the background of the grid
                grid3.setBackground(Color.black);
                grid3.setOpaque(true);
                grid3.setIcon(null);//setting icon to null

                //adding grid3 to the board
                board.add(grid3);

                //setting up grid4
                grid4 = new JLabel(pawn);//placing the image in the background of the grid
                grid4.setBackground(Color.white);
                grid4.setOpaque(true);
                grid4.setIcon(null);//setting icon to null

                //adding grid4 to the board
                board.add(grid4);

                //adding board to the container
                c.add(board);
                //adding buttons to the container
                c.add(buttons);

                //Creating button 1 and adding an image to Button 1
                button1 = new JButton(arrow1);
                buttons.add(button1);
                button1.setEnabled(false);//hard setting the button so that the start up will disable this button

                //Creating button 2 and adding an image to Button 2
                button2 = new JButton(arrow2);
                buttons.add(button2);
                button2.setEnabled(false);//hard setting the button so that the start up will disable this button

                //Creating button 3 and adding an image to Button 3
                button3 = new JButton(arrow3);
                buttons.add(button3);
                button3.setEnabled(false);//hard setting the button so that the start up will disable this button

                //Creating button 4 and adding an image to Button 4
                button4 = new JButton(arrow4);
                buttons.add(button4);
                button4.setEnabled(false);//hard setting the button so that the start up will disable this button

                //Creating button 5 and adding an image to Button 5
                button5 = new JButton(arrow5);
                buttons.add(button5);
                button5.setEnabled(false);//hard setting the button so that the start up will disable this button

                //Creating button 6 and adding an image to Button 6
                button6 = new JButton(arrow6);
                buttons.add(button6);
                button6.setEnabled(true);//hard setting the button so that the start up will enable this button

                //Creating button 7 and adding an image to Button 7
                button7 = new JButton(arrow7);
                buttons.add(button7);
                button7.setEnabled(false);//hard setting the button so that the start up will disable this button

                //Creating button 8 and adding an image to Button 8
                button8 = new JButton(arrow8);
                buttons.add(button8);
                button8.setEnabled(true);//hard setting the button so that the start up will enable this button

                //Creating button 9 and adding an image to Button 9
                button9 = new JButton(arrow9);
                buttons.add(button9);
                button9.setEnabled(true);//hard setting the button so that the start up will enable this button

                //method for button 1
                button1.addActionListener( new ActionListener()
            {
            public void actionPerformed(ActionEvent buttonOne)
                {
                    firstButtonPerformed(buttonOne);
                }
            });

                //method for button 2
                button2.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent buttonTwo)
                {
                    secondButtonPerformed(buttonTwo);
                }
            });
                //method for button 3
                button3.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent buttonThree)
                                {
                                    thirdButtonPerformed(buttonThree);
                                }
            });
                //method for button 4
                button4.addActionListener(new ActionListener()
                {
                public void actionPerformed(ActionEvent buttonFour)
                                {
                                    fourthButtonPerformed(buttonFour);
                                }
            });
                //method for button 5
                button5.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent buttonFive)
                {
                    fifthButtonPerformed(buttonFive);
                }
            });
                //method for button 6
                button6.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent buttonSix)
                {
                    sixthButtonPerformed(buttonSix);
                }
            });
                //method for button 7
                button7.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent buttonSeven)
                {
                    seventhButtonPerformed(buttonSeven);
                }
            });
                //method for button 8
                button8.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent buttonEight)
                {
                    eightButtonPerformed(buttonEight);
                }
            });
                //method for button 9
                button9.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent buttonNine)
                {
                    ninethButtonPerformed(buttonNine);
                }
            });


                setVisible(true);
                setSize(500,500);

        }
            public void firstButtonPerformed(ActionEvent buttonOne)

            {
                //if statement for Grid 4 Button 1 Left Up
                if(grid4.getIcon() == pawn)
                {
                    if(buttonOne.getSource() == button1)
                        {
                            grid4.setIcon(null);
                            grid1.setIcon(pawn);

                            button1.setEnabled(false);
                            button2.setEnabled(false);
                            button3.setEnabled(false);
                            button4.setEnabled(false);
                            button5.setEnabled(false);
                            button6.setEnabled(true);
                            button7.setEnabled(false);
                            button8.setEnabled(true);
                            button9.setEnabled(true);
                        }
                    }//end of if statement
                }

                public void secondButtonPerformed(ActionEvent buttonTwo)
                {
                    //if statement for Grid 3 Button 2 Up
                    if(grid3.getIcon() == pawn)
                    {
                        if(buttonTwo.getSource() == button2)
                        {
                            grid3.setIcon(null);
                            grid1.setIcon(pawn);

                            button1.setEnabled(false);
                            button2.setEnabled(false);
                            button3.setEnabled(false);
                            button4.setEnabled(false);
                            button5.setEnabled(false);
                            button6.setEnabled(true);
                            button7.setEnabled(false);
                            button8.setEnabled(true);
                            button9.setEnabled(true);
                        }
                    }//end of if statement

                    //start of else if statement for button 2 for grid 2
                    else if(grid4.getIcon() == pawn)
                    {
                        if(buttonTwo.getSource() == button2)
                        {
                            grid4.setIcon(null);
                            grid2.setIcon(pawn);

                            button1.setEnabled(false);
                            button2.setEnabled(false);
                            button3.setEnabled(false);
                            button4.setEnabled(false);
                            button5.setEnabled(true);
                            button6.setEnabled(true);
                            button7.setEnabled(false);
                            button8.setEnabled(true);
                            button9.setEnabled(true);
                        }
                    }//end of if statement
                }

            public void thirdButtonPerformed(ActionEvent buttonThree)
            {
                //if statement for Grid 3 Button 3 right Up
                    if(grid3.getIcon() == pawn)
                    {
                        if(buttonThree.getSource() == button3)
                        {
                            grid3.setIcon(null);
                            grid2.setIcon(pawn);

                            button1.setEnabled(false);
                            button2.setEnabled(false);
                            button3.setEnabled(false);
                            button4.setEnabled(true);
                            button5.setEnabled(true);
                            button6.setEnabled(false);
                            button7.setEnabled(true);
                            button8.setEnabled(true);
                            button9.setEnabled(false);
                        }
                    }//end of if statement
            }

            public void fourthButtonPerformed(ActionEvent buttonFour)
            {
                //if statement for Grid 2 Button 4 Left
                    if(grid2.getIcon() == pawn)
                    {
                        if(buttonFour.getSource() == button4)
                        {
                            grid2.setIcon(null);
                            grid1.setIcon(pawn);

                            button1.setEnabled(false);
                            button2.setEnabled(false);
                            button3.setEnabled(false);
                            button4.setEnabled(false);
                            button5.setEnabled(false);
                            button6.setEnabled(true);
                            button7.setEnabled(false);
                            button8.setEnabled(true);
                            button9.setEnabled(true);
                        }
                    }//end of if statement

                    //start of else if statement for button4 for grid 3
                    else if(grid4.getIcon() == pawn)
                    {
                        if(buttonFour.getSource() == button4)
                        {
                            grid4.setIcon(null);
                            grid3.setIcon(pawn);

                            button1.setEnabled(false);
                            button2.setEnabled(true);
                            button3.setEnabled(true);
                            button4.setEnabled(false);
                            button5.setEnabled(true);
                            button6.setEnabled(true);
                            button7.setEnabled(false);
                            button8.setEnabled(false);
                            button9.setEnabled(false);
                        }
                    }//end of else if statement
            }

            public void fifthButtonPerformed(ActionEvent buttonFive)
            {
                //reset Button if statement
                    if (buttonFive.getSource() == button5)
                    {
                        grid1.setIcon(pawn);
                        grid2.setIcon(null);
                        grid3.setIcon(null);
                        grid4.setIcon(null);

                        button1.setEnabled(false);
                        button2.setEnabled(false);
                        button3.setEnabled(false);
                        button4.setEnabled(false);
                        button5.setEnabled(false);
                        button6.setEnabled(true);
                        button7.setEnabled(false);
                        button8.setEnabled(true);
                        button9.setEnabled(true);
                    }//end of reset button if statement
            }

            public void sixthButtonPerformed(ActionEvent buttonSix)
            {
                //if statement for Grid 1 Button 6 Right
                    if (grid1.getIcon() == pawn)
                    {
                        if(buttonSix.getSource() == button6)
                        {
                            grid1.setIcon(null);
                            grid2.setIcon(pawn);

                            button1.setEnabled(false);
                            button2.setEnabled(false);
                            button3.setEnabled(false);
                            button4.setEnabled(true);
                            button5.setEnabled(true);
                            button6.setEnabled(false);
                            button7.setEnabled(true);
                            button8.setEnabled(true);
                            button9.setEnabled(false);
                        }
                    }//end of if statement

                    //start of else if statement for button6 for grid4
                    else if (grid3.getIcon() == pawn)
                    {
                        if(buttonSix.getSource() == button6)
                        {
                            grid3.setIcon(null);
                            grid4.setIcon(pawn);

                            button1.setEnabled(true);
                            button2.setEnabled(true);
                            button3.setEnabled(false);
                            button4.setEnabled(true);
                            button5.setEnabled(true);
                            button6.setEnabled(false);
                            button7.setEnabled(false);
                            button8.setEnabled(false);
                            button9.setEnabled(false);
                        }
                    }//end of else if statement
            }

            public void seventhButtonPerformed(ActionEvent buttonSeven)
            {
                //if statement for Grid 2 Button 7 left Down
                    if(grid2.getIcon() == pawn)
                    {
                        if(buttonSeven.getSource() == button7)
                        {
                            grid2.setIcon(null);
                            grid3.setIcon(pawn);

                            button1.setEnabled(false);
                            button2.setEnabled(true);
                            button3.setEnabled(true);
                            button4.setEnabled(false);
                            button5.setEnabled(true);
                            button6.setEnabled(true);
                            button7.setEnabled(false);
                            button8.setEnabled(false);
                            button9.setEnabled(false);
                        }
                    }//end of if statement
            }

            public void eightButtonPerformed(ActionEvent buttonEight)
            {
                //if statement for Grid 1 Button 8 Down
                    if (grid1.getIcon() == pawn)
                    {
                        if(buttonEight.getSource() == button8)
                        {
                            grid1.setIcon(null);
                            grid3.setIcon(pawn);

                            button1.setEnabled(false);
                            button2.setEnabled(true);
                            button3.setEnabled(true);
                            button4.setEnabled(false);
                            button5.setEnabled(true);
                            button6.setEnabled(true);
                            button7.setEnabled(false);
                            button8.setEnabled(false);
                            button9.setEnabled(false);
                        }
                    }//end of if statement

                    //start of else if statement for button 8 grid4
                    else if (grid2.getIcon() == pawn)
                    {
                        if(buttonEight.getSource() == button8)
                        {
                            grid2.setIcon(null);
                            grid4.setIcon(pawn);

                            button1.setEnabled(true);
                            button2.setEnabled(true);
                            button3.setEnabled(false);
                            button4.setEnabled(true);
                            button5.setEnabled(true);
                            button6.setEnabled(false);
                            button7.setEnabled(false);
                            button8.setEnabled(false);
                            button9.setEnabled(false);
                        }
                    }//end of else if statement
            }

            public void ninethButtonPerformed(ActionEvent buttonNine)
            {
                //if statement for Grid 1 Button 9 Right_down
                    if (grid1.getIcon() == pawn)
                    {
                        if(buttonNine.getSource() == button9)
                        {
                            grid1.setIcon(null);
                            grid4.setIcon(pawn);

                            button1.setEnabled(true);
                            button2.setEnabled(true);
                            button3.setEnabled(false);
                            button4.setEnabled(true);
                            button5.setEnabled(true);
                            button6.setEnabled(false);
                            button7.setEnabled(false);
                            button8.setEnabled(false);
                            button9.setEnabled(false);
                        }
                    }//end of if statement
            }
            public void actionPerformed(ActionEvent e)
            {

            }
        }