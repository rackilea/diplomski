while (height > 0) {
    if ((time % 1.0) < DELTA_T) {
        System.out.printf("%6.2f%10.3f%10.3f\n", time, height, velocity);

    }
    height = (height + (velocity * DELTA_T));
    velocity = (velocity - (GRAVITY * DELTA_T));
    time = (time + DELTA_T);

}