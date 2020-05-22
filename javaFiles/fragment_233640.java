Person personObject = // personObject retrieval is out of scope in this example
        Adress objectAdress = // addressObject retrieval is out of scope in this example
        ArrayList< Person > personCollection = new ArrayList< Person >();
        personCollection.add( personObject );
        Backendless.Data.of( Adress.class ).addRelation( objectAdress, "personId:Adress:n", personCollection,
            new AsyncCallback<Integer>()
            {
                @Override
                public void handleResponse( Integer response )
                {
                    progressDialog.dismiss();
                    Log.i( "MYAPP", "related objects have been added");
                }

                @Override
                public void handleFault( BackendlessFault fault )
                {

                }
            } );