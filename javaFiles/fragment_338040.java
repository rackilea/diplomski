int[][] ray = { { 1, 2 }, { 3, 4 } };

// ray.length == 2
// ray[0].length == 2
// ray[1].length == 2

double avg = 0;

for (int i = 0; i < ray.length; i++) {
    for (int k = 0; k < ray[i].length; k++) {
        avg += ray[i][k];
    }
}

avg /= ray.length * ray[0].length;