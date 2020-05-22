private void addConfigurationValue(String propertyName, String value) {
    value = trim( value );
    configurationValues.put( propertyName, value );

    if ( !propertyName.startsWith( "hibernate." ) ) {
        configurationValues.put( "hibernate." + propertyName, value );
    }
}