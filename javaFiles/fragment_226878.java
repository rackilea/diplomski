JButton nextButton = new JButton("Next");
        buttonPanel.add(nextButton);
        nextButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(bookIndex == inventoryBook.length - 1) {
                    bookIndex = 0;
                } else {
                    bookIndex = bookIndex + 1;
                }

                prepareDisplay(inventoryBook[bookIndex], textArea);
            }
        });