public static boolean pointNearEdge(Point click, Rectangle drawnRectangle, int howNear){
   Rectangle clickRect = new Rectangle(click.x-howNear, click.y-howNear, howNear*2, howNear*2);
   if (drawnRectangle.contains(clickRect))  // totally inside -> false
      return false;

   // test if there is a partial intersection - i.e. we are near the edge
   return drawnRectangle.intersects(clickRect);
}