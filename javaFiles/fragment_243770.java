for(int i=0; i < points;++i) {
    angle1 = i * 2 * Pi / points;
    angle2 = (i+1) * 2 * Pi / points;
    line(OriginX + r * cos( angle1), OriginY + r * sin(angle1),
         OriginX + r * cos( angle2), OriginY + r * sin(angle2)) ;
}