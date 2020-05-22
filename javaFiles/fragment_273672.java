Vec2 screenCenter = Vec2( screensize.x/2, screensize.y/2 ); // half of your screen resolution
                                                            // try changing it to see what happens
                                                            // you can animate it to add special effects
float perspStrength = 500.0f;   // actually an inverse of perspective strength
                                // lower values means bigger effect

Vec2 project( Vec3 pos )        // projection code
{
    Vec2 localPos = pos - screenCenter; // Move point (0,0) to the center of your screen

    float scale = pos.z/perspStrength;  // scale your Z to ~(0-1) range
    scale += 1.0f;                      // move your Z to ~(1-2) range

    localPos.x /= scale;                // scale position according to Z distance
    localPos.y /= scale;

    Vec2 result = localPos + screenCenter;  // Move point (0,0) back to the corner

    return result;
//    return Vec3( result.x, result.y, scale ); // you can also return scale used for this object
                                                // so you can render distant objects as smaller
}