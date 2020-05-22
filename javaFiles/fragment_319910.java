Map<JTextField, String> map = new HashMap<>();
    // add elements in
    map.put(textField1, "6652");
    map.put(textField2, "1142");
    map.put(textField3, "2231");
    ...    

    private void bt1MouseClicked(java.awt.event.MouseEvent evt) 
      // iterate on it
      for (Entry<JTextField, String> entry : map.entrySet()) {
          JTextField field = entry.getKey();
          String value = entry.getValue();
          if (field.getText().equals(value)) {
              field.setBackground(Color.yellow);
          }
      }
    }