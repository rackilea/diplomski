package com.sample;

public class StringWrapper {
    String myString;

    StringWrapper(String newString) {
        this.myString = newString;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((myString == null) ? 0 : myString.toUpperCase().hashCode());
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
        StringWrapper other = (StringWrapper) obj;
        if (this.myString.equalsIgnoreCase(other.myString)) {
            return true;
        }
        return true;
    }

}