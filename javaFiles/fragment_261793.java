@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TwoColors other = (TwoColors) obj;
        if (color1 != other.color1)
            return false;
        if (color2 != other.color2)
            return false;
        return true;
    }