WebElement we;
for(int i=0;i<allopts.size();i++)
{
we=(WebElement)allopts.get(i);
if (condition)//Put your conditions using we like always: xlall.contains(we.getText())
    {
    //code
    break;
    }
}