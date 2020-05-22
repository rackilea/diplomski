public FourVert(Vert V1, Vert V2, float t)
{
    float dx = V2.x - V1.x;
    float dy = V2.y - V1.y;
    float dz = V2.z - V1.z;
    float ex = dx*dz;
    float ey = -dx*dx-dz*dz;
    float ez = dz*dy;
    float d = (float)(t/(2*Math.sqrt(dx*dx+dz*dz)));
    float e = (float)(t/(2*Math.sqrt(ex*ex+ey*ey+ez*ez)));
    dx *= d; dz *= d;
    ex *= e; ey *= e; ez *= e;
    v1 = new Vert( dz+ex,  ey, -dx+ez);
    v2 = new Vert( dz-ex, -ey, -dx-ez);
    v3 = new Vert(-dz-ex, -ey,  dx-ez);
    v4 = new Vert(-dz+ex,  ey,  dx+ez);
    add(V1);
}