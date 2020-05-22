class PersistRunnable implements Runnable {
  final List theObjectsToPersist;
  final String persistenceUnitName;

  public PersistRunnable (List objectsToPersist, String persistenceUnitName) {
      this.theObjectsToPersist = objectsToPersist;
      this.persistenceUnitName = persistenceUnitName;
   }

   @Override
   public void run() {
       // your persistence code referring to those arguments
   }
}