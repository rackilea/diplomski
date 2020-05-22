@EActivity
public class YourActivity extends Activity {

    @Bean
    WeatherPresenter weatherPresenter;

    @AfterInject
    void afterInject() {
        weatherPresenter.loadWeather("New York");
    }
}