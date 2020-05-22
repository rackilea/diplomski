public class FileApplication extends Application {

// for example: public static final String ROOT_URI =
// "file:///C:/restlet-jee-2.0.6/docs/api/";
@Override
public synchronized Restlet createInboundRoot() {

    String ROOT_URI = "file:///"
            + Environment.getExternalStorageDirectory() + "/";

    Directory directory = new Directory(getContext(),
            LocalReference.localizePath(ROOT_URI));
    directory.setListingAllowed(true);
    Router router = new Router(getContext());

    router.attach("/files", directory);

    return router;
}
}