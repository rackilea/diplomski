Scanner inFile = null; 
        StringBuilder builder = new StringBuilder();

        try {
            inFile = new Scanner(new FileReader(curDir + "/scripts/sysinfo.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DropDownTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        while(inFile.hasNextLine()){
            String line = inFile.nextLine();
            builder.append(line);
            builder.append("\n"); // add this for newlines
        }

        JOptionPane.showMessageDialog(null, builder, "System Information", JOptionPane.INFORMATION_MESSAGE);