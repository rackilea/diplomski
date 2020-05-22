package com.mycompany;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class MyPanel extends Panel {

    public MyPanel(String id) {
        super(id);

        add(new Label("hello", Model.of("Hello")));
        add(new Label("world", Model.of("World")));
    }

}