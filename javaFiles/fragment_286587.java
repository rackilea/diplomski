for (int i = 0; i < RenaissanceDatabase.description.length; i++) {
            //STORE THE INDIVIDUAL PAINTINGS AS BUTTONS
            buttonItem = new Button(this);


            painting = new Painting(RenaissanceDatabase.description[i], RenaissanceDatabase.id[i]);

            //USE THE CONTENT DESCRIPTION PROPERTY TO STORE
            //PAINTING DATA

            buttonItem.setId(painting.getId());
....
        }
    }