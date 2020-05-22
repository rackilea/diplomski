struct pnt
 {
 int x,y; // coordinate fo point
 int used; // usage flag for later use
 List<int> ix; // list of indexes of all points connected to this point
 };

struct polylin
 {
 List<int> ix; // list of point indexes
 };

struct polygon
 {
 List<int> lin; // list of polyline indexes
 List<int> dir; // direction of polyline (forward/backward)
 };

List<pnt> pnts;
List<polylin> plins;
List<polygon> faces;