int[][] rect1 = {{2,0},{3,1}};
int[][] rect2 = {{0,0},{1,2}};

int rect1X1 = rect1[0][0];
int rect1X2 = rect1[1][0];
int rect1Y1 = rect1[0][1];
int rect1Y2 = rect1[1][1];

int rect2X1 = rect2[0][0];
int rect2X2 = rect2[1][0];
int rect2Y1 = rect2[0][1];
int rect2Y2 = rect2[1][1];

if (rect1X2 >= rect2X1 && rect1Y2 >= rect2Y1 && rect1X1 <= rect2X2 && rect1Y1 <= rect2Y2)
{
    System.out.println("Collision");
} else {
    System.out.println("No Collision");
}