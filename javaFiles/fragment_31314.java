package com.example.el;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class Functions{

    private Functions() {
        // Hide constructor.
    }

    public static String formatDate(Date date, String pattern) {
        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        return new SimpleDateFormat(pattern, locale).format(date);
    }

}