private String generateURL(BoxItem item) {
     if (item instanceof BoxFolder) {
         if (item.getInfo().getParent() == null) {
             return "https://app.box.com/folder/0";
         } else {
             return String.format("https://app.box.com/folder/%s", item.getInfo().getParent().getID());
         }
     } else {
         return String.format("https://app.box.com/file/%s", item.getID());
     }
 }