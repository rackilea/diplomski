package your.package.name;

import com.parse.Parse;
import com.parse.ParseUser;

public class Application extends android.app.Application {

@Override
public void onCreate() {
    super.onCreate();
    Parse.initialize(this, "YOUR_APP_ID", "YOUR_CLIENT_KEY");
    }

}