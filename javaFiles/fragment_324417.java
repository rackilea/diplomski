int index = -1;

for (int i = 0; i < pointList.size(); i++)
    if (pointList.get(i).x == 1) {
        index = i;
        break;
    }

// now index is the location of the first element with x-val 1
// or -1 if no such element exists