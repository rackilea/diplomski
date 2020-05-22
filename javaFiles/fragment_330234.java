for (int i = 1; i <= 3; i++) {
     int threeLuckyNumbers = (int)(Math.random() * 10);

     if (userLuckyNumber == threeLuckyNumbers) {
      JOptionPane.showMessageDialog(null, "you hit a happy number");
     } else {
      JOptionPane.showMessageDialog(null, "you did not hit a lucky number");
     }

      break;
    }