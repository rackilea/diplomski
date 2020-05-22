class DialogPrint
    {
        public static void main(String[] args)
        {
            // Prompt user to enter numbers
             String stringInteger = JOptionPane.showInputDialog(null, "Enter a integer n to determine the size of matrix: ", "Size of Matrix Input", JOptionPane.INFORMATION_MESSAGE);

            // Convert string to integer
            int n = Integer.parseInt(stringInteger);
            printMatrix(n);
        }   

        // Generate and display random 0's and 1's accordingly
        public static void printMatrix(int n)
        {
            // Row depending on n times



            String sb="";


            for (int row = 0; row < n; row++)
            {
                // Column depending on n times
                for (int col = 0; col < n; col++)
                {
                    String randomN = ((int)(Math.random() * 2)+ " ");
                    sb+=randomN;
                }
                sb+="\n";
            }

            System.out.print(sb);

            JOptionPane.showMessageDialog(null, sb);

        }
    }