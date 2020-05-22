while(m.find()) {
   for (c=2; c<=m.groupCount(); c++) {
       if (m.group(c) != null) {
           domElement.setAttribute("rid", "fig" + m.group(c));
           break;
       }
   }
}