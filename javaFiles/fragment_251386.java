for (int a = 0; a < nameValues.size(); a++) {
     if (customList.getName().equalsIgnoreCase(nameValues.get(a).getName())) {
          value.setText(String.valueOf(nameValues.get(a).getValue()));
     } else {
          value.setText("");
     }
 }