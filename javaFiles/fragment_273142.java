public enum GameType {
  SLAYER {
    @Override
    public GameListener getListener(CustomGame cg)
      return new SlayerListener(cg);
    }
  },
  // ... similarly for other GameListener types

  public abstract GameListener getListener(CustomGame cg);
}