public void ReturnMapData(LatLng arg) {
    Intent intent = this.getIntent();
    intent.putExtra("latitude", String.valueOf(arg.latitude));
    intent.putExtra("longitude", String.valueOf(arg.longitude));
    this.setResult(RESULT_OK, intent);
}