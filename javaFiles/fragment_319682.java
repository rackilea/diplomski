userChoice =JOptionPane.showInputDialog(null, "Enter one of the following as your choice: \n Rock: (valid choices include 0, r, rock) \n Paper: (valid choices include 1, p, paper) \n Scissors: (valid choices include 2, s, scissors)");
yourChoice = Integer.parseInt(userChoice);

ConvertStringtoNum(userChoice);

yourChoice= ConvertStringtoNum(userChoice);