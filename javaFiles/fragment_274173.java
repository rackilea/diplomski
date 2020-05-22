public void show(View view) {
    checkPermissionOverlay();
    Intent svc = new Intent(this, OverlayService.class);
    svc.putExtra(DataItemAdapter.ITEM_KEY, dataItem);
    startService(svc);
    notificationService();
}