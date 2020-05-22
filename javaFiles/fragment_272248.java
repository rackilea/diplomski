JButton square = new JButton();
square.setFont(new Font("Verdana", Font.PLAIN, 20));
ActionListener bh = new button_handler();
actionListeners[buttonCount++] = bh; // store the handler in an array for later
square.addActionListener(bh);
grid.add(square);