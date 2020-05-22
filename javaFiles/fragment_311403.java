if (args.length > 0) {
       File f = new File(args[0]);
       start_the_application_with_a_file(f);
   } else {
       start_the_application_without_a_file();
   }