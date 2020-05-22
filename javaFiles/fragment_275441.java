// The degrees of each Corner of the Cube
int topLeftDegree = r+45;
int topRightDegree = r+135;
int botRightDegree = r+225;
int botLeftDegree = r+315;

Point topLeftPoint = new Point(GetRotatedRecPoint(topLeftDegree, cubeSize, centerPoint));
Point topRightPoint = new Point(GetRotatedRecPoint(topRightDegree, cubeSize, centerPoint));
Point botRightPoint = new Point(GetRotatedRecPoint(botRightDegree, cubeSize, centerPoint));
Point botLeftPoint = new Point(GetRotatedRecPoint(botLeftDegree, cubeSize, centerPoint));