public CompletionStage<Void> leaveGame(GameService gameService)
{
    return CompletableFuture.runAsync(() -> System.out.println("BLAH"))
        .thenCompose(voidArg -> gameService.deregister(playerName)
                                  .exceptionally(t -> {
                                    LOGGER.info("Could not deregister: {}", t.getMessage());
                                    throw new CompletionException(t);
                                  }));
}