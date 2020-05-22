FileFilter filter = new FileFilter() {

        @Override
        public boolean accept(File pathname) {
             if(pathname.isDirectory())
             {
                 System.out.println("%%%%%%%%%%%"+pathname);
                return true;
             }
             else
             {
                 System.out.println("*****"+pathname);
                 return pathname.getName().endsWith(".txt");
             }
        }
     };