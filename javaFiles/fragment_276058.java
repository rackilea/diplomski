double radius = diameter / 2;

     for(double X = -radius; X < radius; X++ )
        for(double Y = -radius; Y < radius; Y++ )
            for(double Z = -radius; Z < radius; Z++ )
                if(Math.sqrt((X * X) + (Y * Y) + (Z * Z)) <= radius)
                    SetInShere(X,Y,Z);