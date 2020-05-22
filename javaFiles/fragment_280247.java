public static List<Double> cast(double angle, double step, List<Double> list) {
    while(true) {
        double x = px + Math.sin(angle / 180 * Math.PI) * step;
        double z = pz + Math.cos(angle / 180 * Math.PI) * step;

        if ((int) x < 0 || (int) x > mapWidth - 1 || (int) z < 0 || (int) z > mapHeight - 1) {
            break;
        }

        list.add(getHeight(x,z));
        step += quality;
    }

    return list;
}