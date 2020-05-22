package android.mobile.peakgames.net.aspectjandroid;

import org.apache.http.auth.AuthenticationException;

import android.app.Activity;
import android.mobile.peakgames.net.aspectjandroid.exception.NoTryCatch;

public class AspectActivity extends Activity {
  public String doSomething() {
    System.out.println("Doing something");
    return "something";
  }

  @NoTryCatch
  public String doSomethingElse() {
    System.out.println("Doing something else");
    throw new RuntimeException("oops");
  }

  public String doSomethingFancy() throws AuthenticationException {
    System.out.println("Doing something fancy");
    throw new AuthenticationException("uh-oh");
  }

  public void run() throws AuthenticationException {
    doSomething();
    doSomethingElse();
    doSomethingFancy();
  }

  public static void main(String[] args) throws AuthenticationException {
    new AspectActivity().run();
  }
}