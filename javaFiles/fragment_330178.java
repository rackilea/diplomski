rb.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
           if(rb.getChecked())
           {
                String toBinray=this.editText.getText().toString();
                String bin=Integer.toBinaryString(Integer.valueOf(toBinray));
                this.displayText.setText(bin);
           }
           else
           {
                // Convert the binary value to integer
           }
        }
    });