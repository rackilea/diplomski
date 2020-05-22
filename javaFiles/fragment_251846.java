private Location getStart( int angle )
        {
            double a = width / 2.0;
            double b = height / 2.0;
            double c = Math.sqrt( ( a * a ) + ( b * b ) );

            int ang= (int) Math.toDegrees(Math.atan( Math.min(a,b)/Math.max(a,b))) ;

            int angle2 = ( angle + 180 + ang ) % 360;
            return getEnd( c , angle2 , center );
        }