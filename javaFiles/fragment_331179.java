@Module(injects = { MapMarker.class, MapMarkerTest.class })
public class AFirstDaggerModule {

    @Provides @Singleton
    RailsMapMarker provideRailsMapMarker() {
        System.out.println("inside dagger - mock");
        return mock(RailsMapMarker.class);

    }

}