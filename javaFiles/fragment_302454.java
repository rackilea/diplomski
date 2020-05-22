if ((isEmpty(firstName))||(isEmpty(lastName))||(isEmpty(Age))||(isEmpty(phoneNumber)))
    {
        String text="Following fields are empty:";
                if ((isEmpty(firstName))||(isEmpty(lastName))){
                    text +="\nName";
                }
                if ((isEmpty(Age))){
                    text +="\nAge";
                }
                if ((isEmpty(phoneNumber))){
                    text +="\nPhone Number";
                }
                Toast toast=Toast.makeText(this, text, Toast.LENGTH_SHORT);
                toast.show();
            }