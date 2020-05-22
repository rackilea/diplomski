public List<List<LatLng>> allMyHoles(){

        // list to hold all holes
        List<List<LatLng>> holes = new ArrayList<>();

        // location one
        List<LatLng> hole1 = new ArrayList<>();
        hole1.add(new LatLng(51.509959, -0.181208));
        hole1.add(new LatLng(51.511288, -0.158354));
        hole1.add(new LatLng(51.506520, -0.152773));
        hole1.add(new LatLng(51.512158, -0.174572));
        hole1.add(new LatLng(51.522434, -0.197979));

        holes.add(hole1);

        // location 2
        List<LatLng> hole2 = new ArrayList<>();
        hole2.add(new LatLng(51.500216, -0.166685));
        hole2.add(new LatLng(51.544934, -0.152737));
        hole2.add(new LatLng(51.547666, -0.152949));
        hole2.add(new LatLng(51.544964, -0.156916));
        hole2.add(new LatLng(51.535335, -0.14565));
        hole2.add(new LatLng(51.533599, -0.156538));

        holes.add(hole2);

        return holes;

    }