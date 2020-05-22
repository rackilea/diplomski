Bundle bun = getIntent().getExtras();
if(bun != null)
{
    rollList = bun.getIntegerArrayList("rolls");
    hourList = bun.getIntegerArrayList("hours");
    wageList = bun.getIntegerArrayList("wages");
    payRoll = bun.getInt("roll");
}