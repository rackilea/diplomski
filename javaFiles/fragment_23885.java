add( new AjaxFormComponentUpdatingBehavior( "onchange") {

        @Override
        protected void onUpdate(AjaxRequestTarget target) {
            System.out.println( "Value: "+field.getValue() );

        }
    });