public float toCelsius() {
    switch (scale) {
        case "celsius":
            return temperature;
        case "fahrenheit":
            return (temperature - 32) / 1.8;
    }
    return 0;
}

public boolean equals (Temperature other) {
    return toCelsius() == other.toCelsius();
}