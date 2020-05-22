int x1=0;
  int y1 = 140;
  int x2 = 120;
  int y2 = 140;
  int x3 = 60;
  int y3=0;


           public void paint (Graphics page)
           {
              page.drawLine (x1, y1, x2, y2); 
              page.drawLine (x2, y2, x3, y3);
              page.drawLine (x3, y3, x1, y1); 

              for (x1= 0; x1<=120; x1++)     

           {

              page.drawLine (x3, y3, x1, y1);


           }   }