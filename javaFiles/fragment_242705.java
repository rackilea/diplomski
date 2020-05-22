struct direction
{
     int x, y;
};

direction directions[] =
{
     { 0, 0 },    // Don't move.
     { 0, 1 },    // Right.
     { 0, -1 },   // Left.
     { 1, 0 },    // Down.
     { -1, 0 },    // Up.
 };