@Module(injects = MapMarker.class)
public class AFirstDaggerModule {

    @Provides
    RailsMapMarker provideRailsMapMarker() {
        System.out.println("inside dagger -non mock");
        return new RailsMapMarker();

    }

}