bu_2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            applyBinaryOp(new BinaryOp(){
               public double calc(double arg1, double arg2) {
                   return arg1 * arg2;
               }
            });
        }
    });