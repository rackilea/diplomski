@Override
    public boolean equals(Object o){
        Point p = (Point)o;
        if(dimension != p.coordinates.size())
            return false;
        for(int i = 0; i < p.coordinates.size(); i++){
            if(coordinates.get(i) != p.coordinates.get(i)){
                return false;
            }
        }
        return true;
    }