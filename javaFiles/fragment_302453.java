if ((isEmpty(firstName))||(isEmpty(lastName))||(isEmpty(Age))||(isEmpty(phoneNumber)))
{
    String text="Following fields are empty:";
            if ((isEmpty(firstName))||(isEmpty(lastName))){
                text = text.concat("\nName");
            }
            if ((isEmpty(Age))){
                text = text.concat("\nAge");
            }
            if ((isEmpty(phoneNumber))){
                text = text.concat("\nPhone Number");
            }
            Toast toast=Toast.makeText(this, text, Toast.LENGTH_SHORT);
            toast.show();
        }