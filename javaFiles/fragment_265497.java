public CompletionStage<Void> leaveGame(GameService gameService)
{
  return gameService.deregister(playerName)
                    .exceptionally(t -> {
                      LOGGER.info("Could not deregister: {}", t.getMessage());
                      throw new CompletionException(t);
                    });
}