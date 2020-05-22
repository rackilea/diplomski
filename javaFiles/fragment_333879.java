TreeTableColumn< Pair< Object, Object>, Object > colData = new TreeTableColumn<>("Skills"); colData.setMinWidth(200);
    colData.setCellValueFactory( cellDataFeatures -> {

        //itemKey : Could be a String, IntegerProperty, StringProperty, or ObjectProperty< LocalDate >
        Object item = cellDataFeatures.getValue().getValue().getValue();

        //String
        if ( item instanceof String ){
            return new SimpleObjectProperty<>( item ); 
        }

        //IntegerProperty
        if ( item instanceof IntegerProperty ){
            return new SimpleObjectProperty<>(((IntegerProperty) item).getValue()); 
        }

        //StringProperty
        if ( item instanceof StringProperty ){
            return new SimpleObjectProperty<>(((IntegerProperty) item).getValue()); 
        }

        //ObjectProperty< LocalDate >
        if ( item instanceof ObjectProperty< ? >){
            Object value = (( ObjectProperty<?> ) item ).getBean();
            if ( value instanceof LocalDate ){
                //@TODO LocalDate cell
            }
        }

        // TODO return something appropriate here
        return null ;
    });