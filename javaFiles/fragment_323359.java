package com.mycompany;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {

    public HomePage(final PageParameters parameters) {
        super(parameters);

        Fragment fragment = new Fragment("fragment", "fragment-markup", this);

        fragment.add(new MyPanel("panel"));

        add(fragment);
    }
}