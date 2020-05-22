String listRepresentation = "";
 for (String name : namesArray) {
     if ("".equals(listRepresentation)) {
          listRepresentation += name;
      } else {
          listRepresentation += ", " + name;
      }
 }
 textView1.setText(listRepresentation );