package com.example;

import javafx.scene.control.SplitPane;
import javafx.scene.control.skin.SplitPaneSkin;

public class MySplitPaneSkin extends SplitPaneSkin {

    public MySplitPaneSkin(SplitPane control) {
        super(control);
        consumeMouseEvents(false);
    }

}