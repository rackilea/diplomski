List<String> allStrOpts=new ArrayList<String>();
for (WebElement we : allopts)
{
     allStrOpts.add(we.getText());
}
for(int i=0;i<xlall.size();i++)
{
     if(allStrOpts.contains(xlall.get(i))
     {
           act.keyDown(Keys.CONTROL)
                .click(allopts.get(allStrOpts.indexOf(xlall.get(i))))
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
     }
}