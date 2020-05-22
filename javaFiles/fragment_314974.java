public static void main( String[] args )
           throws Exception
   {
      Connection db;
      db = database( "testdb", "root", "chino130284" );
      mostrarTablas( db );
      DBgui gui = new DBgui();
      gui.mostrarMarco();  // <-- extra 'r'
      gui.mostarMarco();

   }