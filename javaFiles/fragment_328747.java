@Override 
public void run() {
   while (db.getNumLinesOfWantedType() >= wantedNum) {
      webServiceFillDB();
   }
   // The thread terminates here when the database has enough lines.
}