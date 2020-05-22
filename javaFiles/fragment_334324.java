if (newValue == null) {
        newValue = props.getProperty(newKey);
        if (newValue != null && newValue.contains("${")) {
            expandProperty(newValue, platformConfig, props, newKey);
            newValue = props.getProperty(newKey);
         }
     }