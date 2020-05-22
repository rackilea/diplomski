public void int GetWinner()
{
   int result = 0;
   result= CheckHorizontal();
   if(result>0) return result;
   result= CheckVertical();
   if(result>0) return result;
   result= CheckDiagonalTopLeftBotRight();
   if(result>0) return result;
   result= CheckDiagonalBotLeftTopRight();
   return result;
}