Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateString = formatter.format(date);
    formatText = new JFormattedTextField(createFormatter("####-##-## ##:##:##"));
    formatText.setColumns(20);
    formatText.setText(dateString);