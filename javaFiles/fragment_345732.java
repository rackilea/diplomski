String flag = "";
public void onRedBtnClick(View v)
{
    flag = "red";
}
public void scoreBtnClick(View v)
{
    if (!flag.equals(""));
    {
         if ("red".equals(flag))
         {
               redScore += score;
         }
         if ("blue".equals(flag))
         {
               blueScore += score;
         }
}