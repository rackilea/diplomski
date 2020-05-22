SteamIDBtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("OGList.txt"));
            String line=null;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }