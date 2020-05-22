int fuelValue = -1;
try {
fuelValue = Integer.parseInt(fuel.getText().toString());
}
catch (NumberFormatException e)
{
//you don't have to do much here since fuelValue already has a default value (-1)
}