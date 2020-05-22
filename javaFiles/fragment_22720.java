private void createSurface(double time) {
    surface = new SurfacePlotMesh(
        p-> Math.sqrt(Math.pow(Math.exp(-(Math.pow((p.getX() - time), 2))) * 
            (Math.cos((2 * Math.PI * (p.getX() - time)))), 2) + 
            Math.pow(Math.exp(-(Math.pow((p.getX() - time), 2))) * 
            (Math.sin((2 * Math.PI * (p.getX() - time)))), 2)),
            10, 0.1, 64, 2, 2);
}