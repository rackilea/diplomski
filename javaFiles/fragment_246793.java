module hellofx {     
    requires javafx.controls;     
    requires javafx.fxml;     
    requires com.jfoenix;      
    opens org.openjfx to javafx.fxml;     
    exports org.openjfx; 
}