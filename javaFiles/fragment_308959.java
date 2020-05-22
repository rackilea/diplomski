public void getNearbyPlayer(Integer playerId,final String markerId) {
        getNearbyPlayerDetails(new VolleyCallbackNearbyPlayerDetails() {
            @Override
            public void onSuccess(final Player2 nearbyPlayer) {
                playerMap.put(markerId, nearbyPlayer);
            }
        },playerId);
}