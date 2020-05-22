// returns 1 if otherAngle is to the right of sourceAngle,
//         0 if the angles are identical
//         -1 if otherAngle is to the left of sourceAngle
int compareAngles(float sourceAngle, float otherAngle)
{
    // sourceAngle and otherAngle should be in the range -180 to 180
    float difference = otherAngle - sourceAngle;

    if(difference < -180.0f)
        difference += 360.0f;
    if(difference > 180.0f)
        difference -= 360.0f;

    if(difference > 0.0f)
        return 1;
    if(difference < 0.0f)
        return -1;

    return 0;
}