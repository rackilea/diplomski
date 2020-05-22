List<String> itemList = .... your list

for (String item : itemList)
 {
   submenu.add(new Action(item) {
         @Override
         public void run() {
               // implement this
         }
   });
 }