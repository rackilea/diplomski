class MyService extends WearableListenerService {

void onDataChanged() {
if (MyApp.activity != null) {
MyApp.activity.redraw()
}
}

}