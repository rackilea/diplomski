public long[] genVibratorPattern( float intensity, long duration )
{
    float dutyCycle = Math.abs( ( intensity * 2.0f ) - 1.0f );
    long hWidth = (long) ( dutyCycle * ( duration - 1 ) ) + 1;
    long lWidth = dutyCycle == 1.0f ? 0 : 1;

    int pulseCount = (int) ( 2.0f * ( (float) duration / (float) ( hWidth + lWidth ) ) );
    long[] pattern = new long[ pulseCount ];

    for( int i = 0; i < pulseCount; i++ )
    {
        pattern[i] = intensity < 0.5f ? ( i % 2 == 0 ? hWidth : lWidth ) : ( i % 2 == 0 ? lWidth : hWidth );
    }

    return pattern;
}