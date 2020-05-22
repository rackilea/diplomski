static final String PACKAGE_ID = "com.your.package.here:id/"
...
...
int id = <your random id here>
String name = getResources().getResourceName(id);
if (name == null || !name.startsWith(PACKAGE_ID)) {
    // id is not an id used by a layout element.
}