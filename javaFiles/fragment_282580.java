abstract class Service {}

class DataService extends Service {}

class MobileService extends Service {}

class Foo implements GenericObserver<Service, Tools> {
    void update(Service sender, Tools data) {
        if (sender instanceOf DataService) {
            // do something
        } else if (sender instanceOf MobileService) {
            // do something else
        } else {
            // throw some notImplemented exception
        }
    }
}