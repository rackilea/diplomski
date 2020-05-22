package com.gluonhq.magnetometer;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.MagnetometerService;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BasicView extends View {

    public BasicView(String name) {
        super(name);

        Label label1 = new Label();
        Label label2 = new Label();

        Button button = new Button("Start Magnetometer");
        button.setGraphic(new Icon(MaterialDesignIcon.VIBRATION));

        button.setOnAction(e -> 
            Services.get(MagnetometerService.class)
                .ifPresent(s -> s.readingProperty()
                        .addListener((obs, ov, nv) -> {
                            label1.setText(String.format("X: %.4f Y: %.4f Z: %.4f\n Mag: %.4f", nv.getX(), nv.getY(), nv.getZ(), nv.getMagnitude()));
                            label2.setText(String.format("Yaw: %.2f\u00b0 Pitch: %.4f\u00b0 Roll: %.4f\u00b0", Math.toDegrees(nv.getYaw()), 
                                    Math.toDegrees(nv.getPitch()), Math.toDegrees(nv.getRoll())));
                        })));

        VBox controls = new VBox(15.0, button, label1, label2);
        controls.setAlignment(Pos.CENTER);

        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> System.out.println("Menu")));
        appBar.setTitleText("Magnetometer");
    }

}