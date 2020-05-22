for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
{
    iWaterAmount = c.getColumnIndex(KEY_WATER);
    waterAmount = c.getInt(iWaterAmount);
}//end for
c.close();