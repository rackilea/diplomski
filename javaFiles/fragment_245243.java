public double maxAngle()
{
    double a2 = Math.pow(sideAB, 2);
    double b2 = Math.pow(sideBC, 2);
    double c2 = Math.pow(sideAC, 2);
    double cosC = ((b2 + c2)-a2)/((2*sideBC)*sideAC);
    double angleC = Math.acos(cosC);
    angleC = Math.toDegrees(angleC);
    double cosB = ((a2+b2-c2)/(2*sideAB*sideBC));
    double angleB = Math.acos(cosB);
    angleB = Math.toDegrees(angleB);
    double cosA = ((a2+c2-b2)/(2*sideAB*sideAC));
    double angleA = Math.acos(cosA);
    angleA = Math.toDegrees(angleA);
    if (angleA >= angleB && angleA >= angleC)
    {
        return angleA;
    }
    else if(angleB >= angleA && angleB >= angleC)
    {
        return angleB;
    }
    else
    {
        return angleC;
    }       
}