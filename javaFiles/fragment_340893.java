// Radius
int radius = 200;
// center of the circle
int centerX = 300, centerY = 300;

// The number of edges. Set to 5 for a pentagram
int mod = 136;
// The number of "points" to skip - set to 2 for a pentagram
int skip = 45;

// Precalculated multipier for sin/cos
double multi = skip * 2.0 * Math.PI / mod; 

// First point, calculated by hand
int x1 = centerX; // sin(0) = 0
int y1 = centerY + radius; // cos(0) == 1

for (int circle = 1; circle <= mod; circle++)
{
    // Calculate the end point of the line.
    int x2 = (int) (centerX + radius * Math.sin(circle * multi));
    int y2 = (int) (centerY + radius * Math.cos(circle * multi));
    dpGraphics.drawLine(x1, y1, x2, y2);
    // Next start point for the line is the current end point
    x1 = x2;
    y1 = y2;
}