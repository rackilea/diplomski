if (c != null) {
            contentPane.remove(c);
        }
        c = new AddBookInterface(theLibrary);
        contentPane.add(c);
        contentPane.revalidate();
        contentPane.repaint(); 
        frame.validate();
        frame.repaint();
        break;