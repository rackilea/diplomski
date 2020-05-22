Actions rows = new Actions(Base.getdriver());
rows.keyDown(Keys.SHIFT).perform();
for(x = 0 ; x < TRcount.size() ; x++)
{
    TRcount.get(x).click();
}

rows.keyUp(Keys.SHIFT).perform();