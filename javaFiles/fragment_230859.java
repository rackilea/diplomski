private void createControlPanel() {
  int initialRow = 0;
  initSessionControls(controlPanelGB, initialRow);
  initBidControls(controlPanelGB, initialRow+1);
  initSnapshotControls(controlPanelGB, initialRow+2);
}