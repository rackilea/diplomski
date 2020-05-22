public long getXsnapped() {
    return Math.round(this.getX()/this.getEps());
}   
public long getYsnapped() {
    return Math.round(this.getY()/this.getEps());
}   
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(eps);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    if (Math.abs(this.getX())>this.getEps()) {
        // include X only if it is larger than eps
        temp = this.getXsnapped();
        result = prime * result + (int) (temp ^ (temp >>> 32));
    }
    if (Math.abs(this.getY())>this.getEps()) {
        temp = this.getYsnapped();
        result = prime * result + (int) (temp ^ (temp >>> 32));
    }
    return result;
}
@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Point2 other = (Point2) obj;
    if (Double.doubleToLongBits(eps) != Double.doubleToLongBits(other.eps))
        return false;
    boolean answer = true;
    if (Math.abs(this.getX())>this.getEps()
            || Math.abs(other.getX())>this.getEps()) {
        // compare value and sign only if X of both points are larger than eps
        if (this.getXsnapped()!= other.getXsnapped())
            answer = false;         
    }
    if (Math.abs(this.getY())>this.getEps()
            || Math.abs(other.getY())>this.getEps()) {
        // compare value and sign only if Y of both points are larger than eps
        if (this.getYsnapped()!= other.getYsnapped())
            answer &= false;
    }
    boolean isDebug = false;
    Util.debugPrint(isDebug, "p1 %s; p2 %s: %b (eps is %.9f)%n"
        , this, other, answer, this.getEps());
    return answer;
}