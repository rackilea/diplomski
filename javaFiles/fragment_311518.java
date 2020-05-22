public boolean isClose(Particle p) {
    if (Math.sqrt(getX()*getX() +getY()*getY())-Math.sqrt(p.getX()*p.getX() +p.getY()*p.getY())<=2)  {
            return isStuck();
        }
    return <default value>;
}