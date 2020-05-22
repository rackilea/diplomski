ResponseEntity<XBrainTradeList> result1 =
    restTemplate.exchange(
        XBrainTradeQueryURL,
        HttpMethod.POST,
        new HttpEntity(request, headers),
        XBrainTradeList.class);