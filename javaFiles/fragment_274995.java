//this the code to receive int value from another activity

levelunlocked = pref.getInt("Level", 0); 

if(levelunlocked == 2)
{
    f2.setVisibility(View.VISIBLE);
    f2lock.setVisibility(View.GONE);
}
if(levelunlocked == 3)
{
    f3.setVisibility(View.VISIBLE);
    f3lock.setVisibility(View.GONE);
}