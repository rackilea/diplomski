// Returns true if two solid rectangles intersect.
bool rectIntersect(int l1, int t1, int r1, int b1,
                   int l2, int t2, int r2, int b2)
{
     return l1 <= r2 && r1 >= l2 &&
            t1 <= b2 && b1 >= t2;
}