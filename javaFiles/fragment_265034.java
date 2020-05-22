import java.util.*;
public class Connect4 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // DON'T MODIFY THE MAIN METHOD UNLESS FOR DEBUGGING
        //MAKE SURE YOU GET RID OF YOUR MODIFICATIONS HERE BEFORE 

        String[][] board = createEmptyBoard();
        Scanner input = new Scanner(System.in);
        boolean bl = true;

        printPattern(board);

        while(bl) {        
            int player1 = 1 , player2 = 2 ,  userInput;
            System.out.println("Please drop a RED disk at the column between 0 and 6:");
            userInput = input.nextInt();
            dropDisk(board, userInput , player1);
            printPattern(board);

            String win = checkWinner(board);
            if(!win.equals(""))
            {
                System.out.println(win+" is the winner!");
                break;
            }

            System.out.println("Please drop a YELLOW disk at the column between 0 and 6:");
            userInput  = input.nextInt();
            dropDisk(board, userInput , player2);
            printPattern(board);

            win = checkWinner(board);
            if(!win.equals(""))
            {
                System.out.println(win+" is the winner!");
                break;
            }
            /* Write code to announce  if there is  winner and end the game */
        } 
    }

    public static String[][] createEmptyBoard() {
        /* This method prints the first empty pattern for the game DON'T MODIFY THIS METHOD */
        String[][] f = new String[7][15];
        for (int i =0;i<f.length;i++) {
            for (int j =0;j<f[i].length;j++) {
                if (j% 2 == 0) f[i][j] ="|";
                else f[i][j] = " ";

                if (i==6) f[i][j]= "-";
            }
        }
        return f;
    } // end of createEmptyBoard 

    public static void printPattern(String[][] brd) {
        for (int i = 0; i < 7; i++){
            System.out.println(brd[i][0] + brd[i][1]+ brd[i][2]+ brd[i][3]+ brd[i][4]+ brd[i][5]+ brd[i][6]+ brd[i][7]+ brd[i][8]+ brd[i]     [9]+brd[i][10]+ brd[i][11]+ brd[i][12]+ brd[i][13]+ brd[i][14]);
        }
    } // end of printPattern

    public static String dropDisk(String[][] brd, int position, int player) {
        if(position < 0 || position > 6){
            return null;
        }
        String disk = player == 1 ? "R" : "Y";

        int col = 2 * position + 1;
        // start looking for a free slot at the very bottom

        int row = 5;

        while (row >= 0 && !brd[row][col].equals(" ")) {
            // move one row up
            row--;
        }

        // free slot found, disk can be placed
        if (row >= 0) {
            brd[row][col] = disk;        
            return disk;        
        }

        return null;
    } // end of dropDisk

    public static String checkWinner(String[][] brd) {      
        for(int i = 0; i < 6; i++)
        {
            int count = 0;
            for(int j = 0; j < 14; j++)
            {
                if(brd[i][j].equals("R"))
                {
                    count++;
                }
                else count = 0;

                if(count == 4)
                {
                    return "R";
                }
            }        
        }
        //Vertical Check for "Y"
        for(int i = 0; i < 6; i++)
        {
            int count = 0;
            for(int j = 0; j < 14; j++)
            {
                if(brd[i][j].equals("Y"))
                {
                    count++;
                }
                else count = 0;

                if(count == 4)
                {
                    return "Y";
                }
            }        
        }

        // Horizontal Check for "R"
        for(int i = 0; i < 14; i++)
        {
            int count = 0;
            for(int j = 0; j < 6; j++)
            {
                if(brd[j][i].equals("R"))
                {
                    count++;
                }
                else count = 0;

                if(count == 4)
                {
                    return "R";
                }
            }        
        }
        // Horizontal Check for "Y"
        for(int i = 0; i < 14; i++)
        {
            int count = 0;
            for(int j = 0; j < 6; j++)
            {
                if(brd[j][i].equals("Y"))
                {
                    count++;
                }
                else count = 0;

                if(count == 4)
                {
                    return "Y";
                }
            }        
        }

        // Check for a diagonal to the bottom and right
        for(int i = 0; i < brd.length-4; i++)
        {
            for(int j = 1; j < brd[i].length-7; j = j + 2)
            {
                if(brd[i][j].equals("R"))
                {
                    if(brd[i+1][j+2].equals("R") && brd[i+2][j+4].equals("R") && brd[i+3][j+6].equals("R"))
                    {
                        return "R";
                    }
                }
                else if(brd[i][j].equals("Y"))
                {
                    if(brd[i+1][j+2].equals("Y") && brd[i+2][j+4].equals("Y") && brd[i+3][j+6].equals("Y"))
                    {
                        return "Y";
                    }
                }
            }
        }

        // Check for a diagonal to the bottom and left
        for(int i = 0; i < brd.length-4; i++)
        {
            for(int j = brd[i].length-2; j >= 7; j = j - 2)
            {
                if(brd[i][j].equals("R"))
                {
                    if(brd[i+1][j-2].equals("R") && brd[i+2][j-4].equals("R") && brd[i+3][j-6].equals("R"))
                    {
                        return "R";
                    }
                }
                else if(brd[i][j].equals("Y"))
                {
                    if(brd[i+1][j-2].equals("Y") && brd[i+2][j-4].equals("Y") && brd[i+3][j-6].equals("Y"))
                    {
                        return "Y";
                    }
                }
            }
        }

        return "";
    }
}