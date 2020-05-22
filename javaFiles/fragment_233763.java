boolean stopFlag=false;    
do{  
  //check each element of your world array with the enum and draw it  
  for(int i=0;i<yourObjectsArray.length;i++)
   {
      for(int j=0;j<yourObjectsArray[i].length;j++){
        switch(yourObjectsArray[i][j])
        {
          case Objects.Rock: drawRock(i,j);
                             break;
          case Objects.Coin: drawCoin(i,j);
                             break;
          //and so on....
        }
     }
   }
  //you can also put this into a separate function as drawWorld() and pass the objects.

//Key press checking logic here. If user presses exit key [esc] then you set the stopFlag  as true
  if(keypress==KEY_ESC){ stopFlag=true;}  
}while(!stopFlag);