private void getEvents() throws VersionNotFoundException {
    String appVersion = getClass().getPackage().getImplementationVersion();
    if (appVersion == null) {
        throw new VersionNotFoundException();
    }
    gameRepository.findAll().forEach(game-> {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-TBA-App-Id", "4205:"+ appVersion);
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        restTemplate.exchange(getEventsForYearString, HttpMethod.GET, requestEntity, Event.class, game.getYear());
    });
}