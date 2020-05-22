import com.facebook.CallbackManager;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {FacebookModule.class})
public interface FacebookComponent {

public void inject(ActivityMain2 activity);
}