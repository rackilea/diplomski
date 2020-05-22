@Override
public Temperature toCelsius() {
    return this;
}

@Override
public Temperature toFahrenheit() {
    return new Fahrenheit(this.getValue() * 9D / 5D + 32D);
}