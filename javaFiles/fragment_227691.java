public enum JavaEnum{
  ADD{
    public String getSymbol(){ return "+"; }
  };
  abstract String getSymbol();
}