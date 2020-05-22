private long time0, time1;
@Override protected void onPreExecute() {
    time0 = System.currentTimeMillis();
}
@Override protected void onPostExecute(HttpResponse response) {
    time1 = System.currentTimeMillis();
long deltaT = (time1 - time0);
Log.d(TAG, "Execute took "+deltaT+"ms");
}