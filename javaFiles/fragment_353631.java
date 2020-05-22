@ObjectCreate(pattern = "Decision")
public class DecisionNode {

  ...

  @SetNext
  public boolean addCriterionNode(CriterionNode criterionNode) {
    return criterionNodes.add(criterionNode);
  }

}

@ObjectCreate(pattern = "Decision/CriterionGroups/CriterionGroup")
public class CriterionGroupNode {

  ...

  // no SetNext rule on this method
  public boolean addCriterionNode(CriterionNode criterionNode) {
    return criterionNodes.add(criterionNode);
  }

}