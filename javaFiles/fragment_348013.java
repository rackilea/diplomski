if (!email.matches(emailPattern))
{
 Snackbar snackbar = Snackbar.make(view,
 "Invalid email address.Please enter a valid email address" , Snackbar.LENGTH_SHORT);
 snackbar.getView().setBackgroundColor(Color.parseColor("#hexcolor"));
 snackbar.show();
 return;
}