//List<String> copy=xlall.clone();

//or

List<String> copy = new ArrayList<>(xlall) 

WebElement we;
for(int i=0;i<allopts.size();i++)
{
    we=(WebElement)allopts.get(i);
    if (copy.contains(we.getText()))
    {
        act.keyDown(Keys.CONTROL)
                .click(we)
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
        copy.remove(copy.indexOf(we.getText()));
    }
    if(copy.size()<1)
    {
         break;
    }
}