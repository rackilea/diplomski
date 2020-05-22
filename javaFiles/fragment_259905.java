int currentXP;
int lastLevelXP;
int nextLevelXP;
int xpBetweenLevels = nextLevelXP - lastLevelXP;
int xpSinceLevelUp = currentXP - lastLevelXP;
float percentageOfXP = xpSinceLevelUp / (float) xpBetweenLevels;
int barWidth = (int) (percentageOfXP * maxWidth); // maxWidth would be the screen's width

// rendering must use 4 unique points
glColor3f(1f, 0f, 1f);
glBegin(GL_QUADS);
    glVertex2i(x, y);
    glVertex2i(x + (percentageOfXP * maxWidth), y);
    glVertex2i(x + (percentageOfXP * maxWidth), y + height); // where y = 10
    glVertex2i(x, y + height);
glEnd();