int a = 0;
        int b = 1;
        String name, degree;

        for(i=0, i < linesize; i += 2)
        {
            int linesize = line.size();
            String line;
            line = JOptionPane.showInputDialog("Please enter tutor name and 
            their highest earned degree.");
            String[] userinput = line.split("\\s+");
            name = userinput[a];
            degree = userinput[b];
            a++;
            b++;
        }