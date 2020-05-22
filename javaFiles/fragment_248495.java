int offset = 10;

int[] point1 = {15, 25}; //start point
int[] point2 = {42, 37}; //end point

int xDisplacement = point2[0] - point1[0];
int yDisplacement = point2[1] - point1[1];

double theta = Math.toDegrees(Math.atan2(yDisplacement, xDisplacement));        

double[] diplacementVector = {offset*Math.cos(theta), offset*Math.sin(theta)};

point1[0] += diplacementVector[0];
point1[1] += diplacementVector[1];

point2[0] -= diplacementVector[0];
point2[1] -= diplacementVector[1];