try (VirtuellTx lVtx = new VirtuellTx()) {
  try {
    // do something ...
    lVTX.commit();
  } catch (Exception e) {
    lVtx.rollback();
  }
}