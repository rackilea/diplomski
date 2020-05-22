String insertNum = JOptionPane.showInputDialog(null, "Insert a number\n");
    int realNum = Integer.parseInt(insertNum);
    boolean prime = true;
    for (int i = 2; i <= realNum / 2; i++) {
         if (realNum % i == 0) {
              JOptionPane.showMessageDialog(null, "It is not a prime!!");
              prime = false;
              break;
         }
    }
    if (prime) {
         JOptionPane.showMessageDialog(null, "It is a prime!");
    }