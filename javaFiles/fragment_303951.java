x_max = l1x1 > l1x2 ? l1x1 : l1x2;
x_min = l1x1 < l1x2 ? l1x2 : l1x1;

y_max = l1y1 > l1y2 ? l1y1 : l1y2;
y_min = l1y1 < l1y2 ? l1y2 : l1y1;

if ((y_min <= y) && (y_max => y) && (x_min <= x) && (x_max >= x))
    return true;