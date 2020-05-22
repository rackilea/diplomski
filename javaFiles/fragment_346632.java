final ObjectMapper mapper = new ObjectMapper();
Stream.of(
        "{\"orgId\":\"foo\",\"isInitialized\":true,\"vehicle\":{\"make\":\"foo\",\"model\":\"foo\"}}",
        "{\"orgId\":\"bar\",\"isInitialized\":true,\"vehicle\":{\"make\":\"bar\",\"model\":\"bar\",\"numCylinders\":4}}"
)
        .map(json -> {
            try {
                return mapper.readValue(json, Payload.class);
            } catch ( final IOException ex ) {
                throw new RuntimeException(ex);
            }
        })
        .map(Payload::getVehicle)
        .map(BaseVehicle::getClass)
        .forEach(System.out::println);