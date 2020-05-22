@Override
 public void focusLost(FocusEvent e) {
    try {
       if (field.isEditValid()) {
          field.commitEdit();
       }
    } catch (ParseException e1) {
       e1.printStackTrace();
    }
    field.setBackground(Color.WHITE);
    System.out.println(String.valueOf((Long) field.getValue()));
 }