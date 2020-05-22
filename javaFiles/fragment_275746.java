public void onClick(View v) {

         File root = Environment.getExternalStorageDirectory();
         File saveFolder= new File(root, "Save");

         String[] files=saveFolder.list(
            new FilenameFilter() {
                public boolean accept(File dir, String name) {
                //define here you filter condition for every single file
                    return name.startsWith("3_test");

                }
            });

         if(files.length>0) {
             System.out.println("FOUND!");
         } else {
             System.out.println("NOT FOUND!");
         }
     }