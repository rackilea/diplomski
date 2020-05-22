final class ForecastJsonDeserializer
        implements JsonDeserializer<Forecast> {

    // This deserializer does not hold any state and can be instantiated once per application life-cycle.
    private static final JsonDeserializer<Forecast> forecastJsonDeserializer = new ForecastJsonDeserializer();

    private ForecastJsonDeserializer() {
    }

    static JsonDeserializer<Forecast> getForecastJsonDeserializer() {
        return forecastJsonDeserializer;
    }

    @Override
    public Forecast deserialize(final JsonElement jsonElement, final Type type, final JsonDeserializationContext context)
            throws JsonParseException {
        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        return new Forecast(
                context.deserialize(jsonObject.get("grid"), Grid.class),
                context.deserialize(jsonObject.get("timeRelease"), Date.class),
                lightningsExtractor.parseList(jsonObject),
                windsExtractor.parseList(jsonObject.get("wind").getAsJsonObject()),
                precipitationsExtractor.parseList(jsonObject.get("precipitation").getAsJsonObject()),
                skiesExtractor.parseList(jsonObject.get("sky").getAsJsonObject()),
                temperaturesExtractor.parseList(jsonObject.get("temperature").getAsJsonObject()),
                humiditiesExtractor.parseList(jsonObject.get("humidity").getAsJsonObject())
        );
    }

    private static final AbstractExtractor<Integer> lightningsExtractor = new AbstractExtractor<Integer>(compile("lightning(\\d)hour")) {
        @Override
        protected Integer parse(final int index, final JsonObject jsonObject) {
            final String rawLightning = jsonObject.get("lightning" + index + "hour").getAsString();
            if ( rawLightning.isEmpty() ) {
                return null;
            }
            return parseInt(rawLightning);
        }
    };

    private static final AbstractExtractor<Wind> windsExtractor = new AbstractExtractor<Wind>(compile("(?:wdir|wspd)(\\d)hour")) {
        @Override
        protected Wind parse(final int index, final JsonObject jsonObject) {
            String rawSpeed = jsonObject.get("wspd" + index + "hour").getAsString();
            String rawDirection = jsonObject.get("wdir" + index + "hour").getAsString();
            if ( rawSpeed.isEmpty() && rawDirection.isEmpty() ) {
                return null;
            }
            return new Wind(parseFloat(rawSpeed), parseFloat(rawDirection));
        }
    };

    private static final AbstractExtractor<Precipitation> precipitationsExtractor = new AbstractExtractor<Precipitation>(compile("(?:sinceOntime|type)(\\d)hour")) {
        @Override
        protected Precipitation parse(final int index, final JsonObject jsonObject) {
            final String rawSinceOntime = jsonObject.get("sinceOntime" + index + "hour").getAsString();
            final String rawType = jsonObject.get("type" + index + "hour").getAsString();
            if ( rawSinceOntime.isEmpty() && rawType.isEmpty() ) {
                return null;
            }
            return new Precipitation(parseFloat(rawSinceOntime), parseInt(rawType));
        }
    };

    private static final AbstractExtractor<Sky> skiesExtractor = new AbstractExtractor<Sky>(compile("(?:code|name)(\\d)hour")) {
        @Override
        protected Sky parse(final int index, final JsonObject jsonObject) {
            final String rawCode = jsonObject.get("code" + index + "hour").getAsString();
            final String rawName = jsonObject.get("name" + index + "hour").getAsString();
            if ( rawCode.isEmpty() && rawName.isEmpty() ) {
                return null;
            }
            return new Sky(rawCode, rawName);
        }
    };

    private static final AbstractExtractor<Float> temperaturesExtractor = new AbstractExtractor<Float>(compile("temp(\\d)hour")) {
        @Override
        protected Float parse(final int index, final JsonObject jsonObject) {
            final String rawTemperature = jsonObject.get("temp" + index + "hour").getAsString();
            if ( rawTemperature.isEmpty() ) {
                return null;
            }
            return parseFloat(rawTemperature);
        }
    };

    private static final AbstractExtractor<Float> humiditiesExtractor = new AbstractExtractor<Float>(compile("rh(\\d)hour")) {
        @Override
        protected Float parse(final int index, final JsonObject jsonObject) {
            final String rawHumidity = jsonObject.get("rh" + index + "hour").getAsString();
            if ( rawHumidity.isEmpty() ) {
                return null;
            }
            return parseFloat(rawHumidity);
        }
    };

    private abstract static class AbstractExtractor<T> {

        private final Pattern pattern;

        private AbstractExtractor(final Pattern pattern) {
            this.pattern = pattern;
        }

        protected abstract T parse(int index, JsonObject jsonObject);

        private List<T> parseList(final JsonObject jsonObject) {
            final List<T> list = new ArrayList<>();
            for ( final Entry<String, JsonElement> e : jsonObject.entrySet() ) {
                final String key = e.getKey();
                final Matcher matcher = pattern.matcher(key);
                // Check if the given regular expression matches the key
                if ( matcher.matches() ) {
                    // If yes, then just extract and parse the index 
                    final int index = parseInt(matcher.group(1));
                    // And check if there is enough room in the result list because the JSON response may contain unordered keys
                    while ( index > list.size() ) {
                        list.add(null);
                    }
                    // As Java lists are 0-based
                    if ( list.get(index - 1) == null ) {
                        // Assuming that null marks an object that's probably not parsed yet
                        list.set(index - 1, parse(index, jsonObject));
                    }
                }
            }
            return list;
        }

    }

}