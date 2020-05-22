if (a.getSource().equals(submit)) {
      kundeOrdreArrayList.clear();
      for (JTextField field : textfields) {
           kundeOrdreArrayList.add(field.getText());
      }
  }