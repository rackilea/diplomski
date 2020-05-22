if (isValidName(name1) && isValidEmail(email) && isValidPassword(pass)  && isValidPassword(pass) == isValidPassword(pass1) && (check == true) && (yes.isEnabled()==true)) 
{
     Toast msg2;
     msg2 = makeText(Register.this, "Step 1 of registration is completed", Toast.LENGTH_SHORT);
     msg2.show();
     Intent launch;
     launch = new Intent(Register.this, donor.class);
     startActivity(launch);
     donor_insert(view);
}
if (isValidName(name1) && isValidEmail(email) && isValidPassword(pass) && isValidPassword(pass) == isValidPassword(pass1) && (check == true) && (no.isEnabled()==true))
{
     Toast msg3;
     msg3 = makeText(Register.this, "Step 1 of registration is completed", Toast.LENGTH_SHORT);
     msg3.show();
     Intent adopter;
     adopter = new Intent(Register.this, adopter.class);
     startActivity(adopter);
     adopter_insert(view);
}