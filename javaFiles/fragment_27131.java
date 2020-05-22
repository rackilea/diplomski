package com.test;

import java.util.Iterator;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.PortletRequestListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class Translation_portletApplication  extends Application implements PortletRequestListener {

    private User m_user;

    @Override
    public void init() {
        Window window = new Window("Vaadin Portlet Application");
        setMainWindow(window);
        String caption = "Hello Vaadin user!";

        if (m_user != null) {
            caption = caption + " with language id '" + m_user.getLanguageId() + "'";
        }
        window.addComponent(new Label(caption));
    }

    @Override
    public void onRequestEnd(PortletRequest p_request, PortletResponse p_response) {
        System.out.println("onRequestEnd");
    }

    @Override
    public void onRequestStart(PortletRequest p_request, PortletResponse p_response) {
        final ThemeDisplay themeDisplay = (ThemeDisplay) p_request.getAttribute(WebKeys.THEME_DISPLAY);
        m_user =  themeDisplay.getUser();
    }
}