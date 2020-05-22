this.activeCustomerRadio = new OptionGroup( "Filter By:" );  // Pass a string used as caption (title) of the group of radio buttons.
this.activeCustomerRadio.addItems( Boolean.TRUE , Boolean.FALSE );  // Pass item ids to be used in constructing Item objects on our behalf.
this.activeCustomerRadio.setItemCaption( Boolean.TRUE , "Active" ); // Specify a textual label rather than default generated value "true" & "false".
this.activeCustomerRadio.setItemCaption( Boolean.FALSE , "Inactive" );
this.activeCustomerRadio.setValue( Boolean.FALSE );  // Specify which radio button is selected by default.
// Add a listener to react to user selection.
this.activeCustomerRadio.addValueChangeListener( new Property.ValueChangeListener()
{

    @Override
    public void valueChange ( Property.ValueChangeEvent event )
    {
        Notification.show( "Radio Button" ,
                "You chose: " + event.getProperty().getValue().toString() ,
                Notification.Type.HUMANIZED_MESSAGE );
    }
} );