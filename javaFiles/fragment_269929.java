class Test {
    private Map<String, Long> myBalances = new HashMap<>();

    {
       myBalances.put("savings", 500L);
    }

    public long getSavingsBalance(){
      return myBalances.get("savings");
    }

    public long getTotal(){
      long result = 0L;
      for(long value : myBalances.values()){
         result += value;
      }
      return result;
    }
}