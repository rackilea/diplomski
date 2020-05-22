package com.IdeaBurger.client;
import com.IdeaBurger.assets.Images;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class SiteHeader extends Composite {
    private static SiteHeaderUiBinder uiBinder = GWT
            .create(SiteHeaderUiBinder.class);

    @UiField Images res;

    interface SiteHeaderUiBinder extends UiBinder<Widget, SiteHeader> {
    }

    public SiteHeader() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}