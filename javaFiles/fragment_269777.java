import com.parse.Parse;
import android.app.Application;

public class App extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    Parse.initialize(this, PARSE_APPLICATION_ID, PARSE_CLIENT_KEY);
  }
}