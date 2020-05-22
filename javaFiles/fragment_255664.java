Do this in reverse. First hide button, then if true show the button.

    buttonAddProducts.setVisibility(View.GONE);                  
    if(user.equals(true))
      buttonAddProducts.setVisibility(View.VISIBLE);

Or you may put your code when activity start
or in xml  <Button ... android:visibility="gone"/>