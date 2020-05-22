if (clasz.isAssignableFrom(Boolean.class)) {
        value = clasz.cast(Boolean.parseBoolean(str));
    } else if (clasz.isAssignableFrom(Integer.class)) {
        value = clasz.cast(Integer.parseInteger(str));
    } else if (clasz.isAssignableFrom(Float.class)) {
        value = clasz.cast(Float.parseFloat(str));
    }