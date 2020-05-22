Intent intent = getIntent();

            if( intent!= null && intent.getExtras() != null
                    && !intent.getExtras().getString("Title").equals("")
                    && !intent.getExtras().getString("Description").equals("") ) {

                // Activity started with sending title & description

            }
            else {
                // Activity started without sending title & description
            }