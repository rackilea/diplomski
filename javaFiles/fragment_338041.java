double avg = 0;
int lengths = 0;

// loop for ray.length
// ray.length == number of arrays in ray
for (int i = 0; i < ray.length; i++) {
    lengths += ray[i].length;

    // loop for ray[i].length
    // ray[i].length == number of elements in ray[i]
    for (int k = 0; k < ray[i].length; k++) {
        avg += ray[i][k];
    }
}

avg /= lengths;