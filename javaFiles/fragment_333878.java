TreeTableColumn< Pair< Object, Object>, String > colName = new TreeTableColumn<>("People"); colName.setMinWidth(100);
    colName.setCellValueFactory( cellDataFeatures -> {

        // Could be a String, StringProperty, or ObjectProperty< LocalDate >
        Object item   = cellDataFeatures.getValue().getValue().getKey();

        //String
        if ( item instanceof String ){
            return new SimpleStringProperty(( String ) item); 
        }

        //StringProperty
        if ( item instanceof StringProperty ){
            return (( StringProperty ) item ); 
        }

        // must return something: you probably don't want to return null though, so you should fix this as needed.
        return null ;
    });