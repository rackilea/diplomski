float runningTotalForGreen = 0;
for(Float3 hsv: hsvs) 
{
    float diff = (hsv.x - 120) % 180; // mod 180 to normalize cw/ccw on the wheel
    runningTotalForGreen += diff; // lower = closer to green
}