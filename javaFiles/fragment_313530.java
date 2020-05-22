private int[] counters = new int[CircuitType.values().length];

   public void tallySomething() {
      Circuit newCircuit = new Circuit();
      counters[newCircuit.getType().ordinal()]++;
  }