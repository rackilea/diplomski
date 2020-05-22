final class Response {

    final Weather weather = null;
    final Common common = null;
    final Result result = null;

    @Override
    public String toString() {
        return new StringBuilder("Response{")
                .append("weather=").append(weather)
                .append(", common=").append(common)
                .append(", result=").append(result)
                .append('}').toString();
    }

}

final class Weather {

    final List<Forecast> forecast3hours = null;

    @Override
    public String toString() {
        return new StringBuilder("Weather{")
                .append("forecast3hours=").append(forecast3hours)
                .append('}').toString();
    }

}

final class Forecast {

    final Grid grid;
    final Date timeRelease;
    final List<Integer> lightnings;
    final List<Wind> winds;
    final List<Precipitation> precipitations;
    final List<Sky> skies;
    final List<Float> temperatures;
    final List<Float> humidities;

    Forecast(final Grid grid, final Date timeRelease, final List<Integer> lightnings, final List<Wind> winds, final List<Precipitation> precipitations,
            final List<Sky> skies, final List<Float> temperatures, final List<Float> humidities) {
        this.grid = grid;
        this.timeRelease = timeRelease;
        this.lightnings = lightnings;
        this.winds = winds;
        this.precipitations = precipitations;
        this.skies = skies;
        this.temperatures = temperatures;
        this.humidities = humidities;
    }

    @Override
    public String toString() {
        return new StringBuilder("Forecast{")
                .append("grid=").append(grid)
                .append(", timeRelease=").append(timeRelease)
                .append(", lightnings=").append(lightnings)
                .append(", winds=").append(winds)
                .append(", precipitations=").append(precipitations)
                .append(", skies=").append(skies)
                .append(", temperatures=").append(temperatures)
                .append(", humidities=").append(humidities)
                .append('}').toString();
    }

}

final class Grid {

    final String city = null;
    final String county = null;
    final String village = null;
    final double latitude = Double.valueOf(0); // disable inlining the primitive double 0
    final double longitude = Double.valueOf(0); // disable inlining the primitive double 0

    @Override
    public String toString() {
        return new StringBuilder("Grid{")
                .append("city='").append(city).append('\'')
                .append(", county='").append(county).append('\'')
                .append(", village='").append(village).append('\'')
                .append(", latitude=").append(latitude)
                .append(", longitude=").append(longitude)
                .append('}').toString();
    }

}

final class Wind {

    final float speed;
    final float direction;

    Wind(final float speed, final float direction) {
        this.speed = speed;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return new StringBuilder("Wind{")
                .append("speed=").append(speed)
                .append(", direction=").append(direction)
                .append('}').toString();
    }

}

final class Precipitation {

    final float sinceOntime;
    final int type;

    Precipitation(final float sinceOntime, final int type) {
        this.sinceOntime = sinceOntime;
        this.type = type;
    }

    @Override
    public String toString() {
        return new StringBuilder("Precipitation{")
                .append("sinceOntime='").append(sinceOntime).append('\'')
                .append(", type=").append(type)
                .append('}').toString();
    }

}

final class Sky {

    final String code;
    final String name;

    Sky(final String code, final String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringBuilder("Sky{")
                .append("code='").append(code).append('\'')
                .append(", name='").append(name).append('\'')
                .append('}').toString();
    }

}

final class Common {

    @SerializedName("alertYn")
    @JsonAdapter(YnToBooleanJsonDeserializer.class)
    final boolean alert = Boolean.valueOf(false); // disable inlining the primitive boolean false

    @SerializedName("stormYn")
    @JsonAdapter(YnToBooleanJsonDeserializer.class)
    final boolean storm = Boolean.valueOf(false); // disable inlining the primitive boolean false

    @Override
    public String toString() {
        return new StringBuilder("Common{")
                .append("alert=").append(alert)
                .append(", storm=").append(storm)
                .append('}').toString();
    }

}

final class Result {

    final int code = Integer.valueOf(0); // disable inlining the primitive int 0
    final String requestUrl = null;
    final String message = null;

    @Override
    public String toString() {
        return new StringBuilder("Result{")
                .append("code=").append(code)
                .append(", requestUrl='").append(requestUrl).append('\'')
                .append(", message='").append(message).append('\'')
                .append('}').toString();
    }

}