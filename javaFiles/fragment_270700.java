for (int i = 0; i <buttons.length;i++) {
    final int k=i; //should create a final variable to get index. 
    buttons[i] = new JButton("pfdfs");
    btnPnl.add(buttons[i]);
    buttons[i].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            //JSONObject jObject = null;
            JSONObject jObject = null;
                // jObject = null;
                try {
                 jObject = jArray.getJSONObject(k);