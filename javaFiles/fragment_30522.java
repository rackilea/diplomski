package com.example;

import javafx.beans.NamedArg;
import javafx.geometry.Insets;

public class ScaledInsets extends Insets {

    public ScaledInsets(@NamedArg(value = "scale", defaultValue = "1") double scale,
                        @NamedArg("top") double top, @NamedArg("right") right,
                        @NamedArg("bottom") double bottom, @NamedArg("left") double left) {
        super(scale * top, scale * right, scale * bottom, scale * left);
    }

    public ScaledInsets(@NamedArg(value = "scale", defaultValue = "1") double scale,
                        @NamedArg("topRightBottomLeft") double topRightBottomLeft) {
        super(scale * topRightBottomLeft);
    }

}