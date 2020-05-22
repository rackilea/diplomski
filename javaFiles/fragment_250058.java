String input = JOptionPane.showInputDialog("Input string");
        int count = input.length() / 20 + 1;
        for(int  i = 0;i < count;i++)
        {
            System.out.println(input.substring(i * 20, (i + 1) * 20 >= input.length() ? input.length() : (i + 1) * 20));
        }