public int toMinutes (int encoded) {
    int minutes = encoded % 100;
    minutes += (encoded / 100) * 60;
    return minutes;
}

public int toEncoded (int minutes) {
    int encoded = minutes % 60;
    encoded += (minutes / 60) * 100;
    return encoded;
}