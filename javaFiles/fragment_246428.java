private const double EARTH_RADIUS_MI = 3959; //In statute miles

    public static float Radians(double degrees)
    {
        return (float)(degrees * (Math.PI / 180));
    }

    public static double CalculateDistance(Coordinates fromPoint, Coordinates toPoint)
    {
        double dLat = Radians(toPoint.Latitude - fromPoint.Latitude);
        double dLon = Radians(toPoint.Longitude - fromPoint.Longitude);

        double a = Math.Sin(dLat / 2) * Math.Sin(dLat / 2) +
            Math.Cos(Radians(fromPoint.Latitude)) * Math.Cos(Radians(toPoint.Latitude)) *
            Math.Sin(dLon / 2) * Math.Sin(dLon / 2);

        double c = 2 * Math.Atan2(Math.Sqrt(a), Math.Sqrt(1 - a));

        return EARTH_RADIUS_MI * c;
    }