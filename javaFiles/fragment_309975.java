@AppScope
@Component
public interface AppComponent {

}


@Component(modules = {FacebookModule.class})
public interface FacebookComponent extends AppComponent {

}


@Component(modules = {AnotherModule.class})
public interface AnotherComponent extends AppComponent {

}


@FragmentScope
@Component(dependencies = {FacebookComponent.class, AnotherComponent.class}, 
           modules = {FragmentFacebookLoginModule.class})
public interface FragmentFacebookLoginComponent {

    void inject(FragmentFacebookLogin fragment);
}