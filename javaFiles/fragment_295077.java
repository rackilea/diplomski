module mosaic.viewer {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires vlcj;
    requires jackson.annotations;
    requires jackson.databind;
    requires jackson.core;
    requires google.http.client;
    requires org.slf4j;
    requires jsr305;

    opens me.project.mosaic.login to javafx.fxml;
    exports me.project.mosaic;
}