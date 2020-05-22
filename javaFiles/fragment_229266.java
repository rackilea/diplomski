for (int i = 1; i < _CreatePlayers.length; i++) {
        final int finalI = i;
        _CreatePlayers[i] = new JTextField("Player " + i+" input name here");
        _CreatePlayers[i].addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                _CreatePlayers[finalI].setText("");
            }
        });
    }