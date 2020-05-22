//Test if OBB b intersects plane p
int TestOBBPlane(OBB b, Plane p)
{
   // Compute the projection interval radius of b onto L(t) = b.c + t * p.n
   float r = b.e[0]*Abs(Dot(p.n, b.u[0])) +
      b.e[1]*Abs(Dot(p.n, b.u[1])) +
      b.e[2]*Abs(Dot(p.n, b.u[2]));

   // Compute distance of box center from plane
   float s = Dot(p.n, b.c) – p.d;

   // Intersection occurs when distance s falls within [-r,+r] interval
   return Abs(s) <= r;
}