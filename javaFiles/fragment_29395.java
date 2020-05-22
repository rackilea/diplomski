class Shape { ... };
class Square : public Shape { ... } ;
class Triangle  : public Shape { ... };

enum ShapeID { SquareID, TriangleID, ... }

Shape *shapeFactory(ShapeID id)
{
   switch(id) 
   {
      case SquareID:   return new Square;
      case TriangleID: return new Triangle;
       ...
   };
   return NULL;
}