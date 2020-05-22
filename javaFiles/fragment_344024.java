Imports: {
  import gate.stanford.DependencyRelation;
}

Phase: GetTokenDepsPhase
Input: Token
Options: control = all
Rule: GetTokenDepsRule
(
  {Token}
): token
--> 
:token {
  //note that tokenAnnots contains only a single annotation so the loop could be avoided...
  for (Annotation token : tokenAnnots) {
    Object deps = token.getFeatures().get("dependencies");

    //sometimes the dependencies feature is missing - skip it
    if (deps == null) continue;

    //token.getFeatures().get("string") could be used instead of gate.Utils.stringFor(doc,token)...
    System.out.println("Dependencies for token " + gate.Utils.stringFor(doc, token));

    //the dependencies feature has to be typed to List<DependencyRelation>
    List<DependencyRelation> typedDeps = (List<DependencyRelation>) deps;
    for (DependencyRelation r : typedDeps) {

      //use DependencyRelation.getTargetId() to get the id of the target token
      //use inputAS.get(id) to get the annotation for its id
      Annotation targetToken = inputAS.get(r.getTargetId());

      //use DependencyRelation.getType() to get the dependency type
      System.out.println("  " +r.getType()+ ": " +gate.Utils.stringFor(doc, targetToken));
    }
  }
}