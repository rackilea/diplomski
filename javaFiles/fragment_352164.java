Vector vector = new Vector(length);

    for (int i = 0; i < length; i++) {
        vector.add(start += start + step);
    }

    return vector;