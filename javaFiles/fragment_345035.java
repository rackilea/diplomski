package com.uk.mysqlmaven.util;


import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class ResourceKeys {

private static ResourceKeys instance = new ResourceKeys();
private ResourceBundle resourceBundle;

private ResourceKeys() {

}

/**
 * Return singleton instance of this class
 * @return singleton instance
 */
public synchronized static ResourceKeys  getInstance() {
    return instance;
}

/**
 * Return value of the key
 * @param key
 * @param bundleName 
 * @return value
 */
public String get(String key, String bundleName) {
    Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    resourceBundle = ResourceBundle.getBundle(bundleName, locale);
    return resourceBundle.getString(key);
}

}