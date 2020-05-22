@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color1 == null) ? 0 : color1.hashCode());
        result = prime * result + ((color2 == null) ? 0 : color2.hashCode());
        return result;
    }