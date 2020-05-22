ZoneRulesProvider.registerProvider(new ZoneRulesProvider() {
        @Override
        protected Set<String> provideZoneIds() {
            return Collections.singleton("HST");
        }

        @Override
        protected ZoneRules provideRules(String zoneId, boolean forCaching) {
            return ZoneRules.of(ZoneOffset.ofHours(10));
        }

        @Override
        protected NavigableMap<String, ZoneRules> provideVersions(String zoneId) {
            TreeMap map =  new TreeMap<>();
            map.put("HST",ZoneRules.of(ZoneOffset.ofHours(10)));
            return  map;
        }
    });

    DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .append(DateTimeFormatter.ISO_LOCAL_DATE)
            .appendLiteral('T')
            .append(DateTimeFormatter.ISO_LOCAL_TIME)
            .appendZoneId()                
            .toFormatter();

    ZonedDateTime timestamp = ZonedDateTime.parse("2018-10-29T12:00:12.456HST", formatter);
    System.out.println(timestamp);