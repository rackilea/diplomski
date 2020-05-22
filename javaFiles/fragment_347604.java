// Under the class definition
private static long lastFrame;
private static long getTime() {
return (Sys.getTime() * 1000) / Sys.getTimerResolution();
}
private static double getDelta() {
long currentTime = getTime();
double delta = (double) currentTime - (double) lastFrame;
lastFrame = getTime();
return delta;
}
// In initialization code
lastFrame = getTime();
// In game loop
long delta = getDelta();
movement_x += dx * delta;