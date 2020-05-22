private static int getWeight(Scenario scenario, List<String> visited) throws Exception{
  int numDep = 0;
  visited.add(scenario.name);
  if(scenario.dependsOnScenarios != null){
      for(String dependency:scenario.dependsOnScenarios) {
          if(visited.contains(dependency)){
             throw new Exception("Circular Reference: "+String.join("->",visited)+"->"+dependency);
          }
      }
      for(String dependency:scenario.dependsOnScenarios) {              
          return scenario.dependsOnScenarios.length + getWeight(allScenarios.get(dependency),visited);
      }
  }
  return numDep;
}