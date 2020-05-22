if(e.getSource()==r2){
        System.out.println("r2 pressed");
        ((GridLayout) this.getLayout()).setRows(4);
        ((GridLayout) this.getLayout()).setRows(4);
        for(int i=0; i<7; i++){
            buttons[i]=new JButton();
            this.add(buttons[i]);
        }

        validate()
        repaint();
    }