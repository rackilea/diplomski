//button    

        private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         

        DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        String date = fmt.format(this.txt_data_ini.getDate()); //jdatechooser
        this.teste.setText(date);

    }