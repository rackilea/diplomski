try {
     data = new GameData.Builder().enemy(enemy).build();
     log.fine("new data object\t\t" + data.getEnemy());
     setChanged();
     notifyObservers(data);
} catch (NullPointerException npe) {
     log.log(Level.SEVERE, npe.getMessage(), npe);
}