JLayeredPane tableMat = new JLayeredPane();
        int i =0;
        int x_offset = 15;
        for (CardSet card : playersHand) {

            String path = dirPath + card.suit().toString()+"-"+card.rank().toString()+".gif";
            File file = new File(path);

            if (!file.exists()) {
                System.out.println(path);
                throw new IllegalArgumentException("file " + file + " does not exist");


            } else {
                BufferedImage icon = ImageIO.read(new File(file.getAbsolutePath()));
                JLabel cardIcon = new JLabel(new ImageIcon(icon));
                cardIcon.setBounds(x_offset,20,300,300);
                tableMat.add(cardIcon, new Integer(i));
                i++;
                x_offset += 15;

            }

        }