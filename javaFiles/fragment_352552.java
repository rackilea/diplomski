double A = (minx > 0 && miny > 0) ? integral_image[miny-1][minx-1] : 0;
double B = (minx > 0) ? integral_image[maxy][miny-1] : 0;
double C = (miny > 0) ? integral_image[miny-1][maxx] : 0;
double D = integral_image[maxy][maxx];

double sum = A - B - C + D;