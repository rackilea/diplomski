public class MainController {

    ...

    private void setResource(Node node, String resource) {
        URL url = getClass().getResource(resource);
        if (url == null) {
            throw new IllegalArgumentException("Resource not available: " + resource);
        }
        node.setUserData(url);
    }

    private static URL getResource(Object source) {
        return (URL) ((Node) source).getUserData();
    }

    @FXML
    private void initialize() {
        setResource(trackerButton, "/view/TrackerPane.fxml");
        setResource(progressButton, "/view/ProgressPane.fxml");
        setResource(communityButton, "/view/CommunityPane.fxml");
        setResource(blockerButton, "/view/BlockerPane.fxml");
        setResource(settingsButton, "/view/SettingsPane.fxml");
    }
}