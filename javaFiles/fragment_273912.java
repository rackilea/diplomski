public MyActivity extends Activity {
void onCreate() {
MyApp.activity = this;
}

void onDestroy() {
MyApp.activity = null;
}

void redraw() {
//redraw
}

}