public static void main(String[] args) {
        String nr = JOptionPane.showInputDialog("Jepni nr e lojtareve");
        int n = Integer.parseInt(nr);
        if (n < 1 || n > 4)
        {
            System.err.println("...");
            return;
        }
        String[] emrat = new String[n];
        for(int i=0; i<n; i++)
        {
            emrat[i]=JOptionPane.showInputDialog("Jepni emrin");
        }
        Background d = new Background(emrat);
    }
}