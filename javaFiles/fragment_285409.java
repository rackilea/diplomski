public class MyActivity extends Activity {
     ...
     protected void doSomething() {
        // this refer to the MyActivity instance which is a Context.
        DateUtils.formatDateTime(this, ...);
     }
     ...
 }