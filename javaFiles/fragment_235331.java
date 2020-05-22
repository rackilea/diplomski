@Override
protected void onStart() {
  super.onStart();

  if (playIntent == null) {
    playIntent = new Intent(this, MusicService.class);
  }
}

@Override
protected void onStart() {
    super.onStart();
    if (CheckPermissions()) {
        Prepare();
    }
}