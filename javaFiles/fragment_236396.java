package com.example.i18n;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

public class Text extends ResourceBundle {

    private static final String TEXT_ATTRIBUTE_NAME = "text";
    private static final String TEXT_BASE_NAME = "com.example.i18n.text";

    private Text(Locale locale) {
        setLocale(locale);
    }

    public static void setFor(HttpServletRequest request) {
        if (request.getSession().getAttribute(TEXT_ATTRIBUTE_NAME) == null) {
            request.getSession().setAttribute(TEXT_ATTRIBUTE_NAME, new Text(request.getLocale()));
        }
    }

    public static Text getCurrentInstance(HttpServletRequest request) {
        return (Text) request.getSession().getAttribute(TEXT_ATTRIBUTE_NAME);
    }

    public void setLocale(Locale locale) {
        if (parent == null || !parent.getLocale().equals(locale)) {
            setParent(getBundle(TEXT_BASE_NAME, locale));
        }
    }    

    @Override
    public Enumeration<String> getKeys() {
        return parent.getKeys();
    }

    @Override
    protected Object handleGetObject(String key) {
        return parent.getObject(key);
    }

}