public interface UserLeft {
  public void userleft();
}

public class A extends Activity implements UserLeft {

void onCreate(Bundle savedInstanceState) {
    H.getInstance().setactivity(this);
}

public void userleft() {

}
}

public class B extends Activity implements UserLeft {

void onCreate(Bundle savedInstanceState) {
    H.getInstance().setactivity(this);
}

public void userleft() {

}
}

public class C extends Activity implements UserLeft {

void onCreate(Bundle savedInstanceState) {
    H.getInstance().setactivity(this);
}

public void userleft() {

}
}

public class H {
UserLeft activity;
public static H getInstance() {
    if (instance == null) {
        instance = new H();
    }
    return instance;
}

public void setActivity(UserLeft activity) {
    this.activityGame = activity;
}
public void randomCallBack(){
    activityGame.userleft(); 
}
}