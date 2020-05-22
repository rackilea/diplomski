public Direction getOpposite() {
   switch (this) {
      case Up:
         return Down;
      case Down:
         return Up;
      case Left:
         return Right;
      case Right:
         return Left;
   }
   return null;
}