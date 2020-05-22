for(int i=0; i<15; i++) 
{
    String imageID = "img" + (i);
    int resID = getResources().getIdentifier(imageID, "drawable", getPackageName());

  /* if you want to reference any widgets like Button, TextView, ImageView, etc. then write below code:

    //int resID = getResources().getIdentifier(imageID, "id", getPackageName());   
  */
}