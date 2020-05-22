RulesModule rules = new AbstractRulesModule() {
  @Override
  public void configure() {

    forPattern("Decision")
        .createObject().ofType(DecisionNode.class);

    forPattern("Decision/Name").addRule(new BeanPropertySetterRule("name"));
    forPattern("Decision/Description").addRule(new BeanPropertySetterRule("description"));
    forPattern("Decision/Url").addRule(new BeanPropertySetterRule("url"));
    forPattern("Decision/ImageUrl").addRule(new BeanPropertySetterRule("imageUrl"));

    forPattern("Decision/CriterionGroups/CriterionGroup")
        .createObject().ofType(CriterionGroupNode.class)
        .then().setNext("addCriterionGroupNode");

    forPattern("Decision/CriterionGroups/CriterionGroup/Name").addRule(new BeanPropertySetterRule("name"));
    forPattern("Decision/CriterionGroups/CriterionGroup/Description").addRule(new BeanPropertySetterRule("description"));

    forPattern("*/Criterion")
        .createObject().ofType(CriterionNode.class)
        .then().setNext("addCriterionNode");

    forPattern("*/Criterion/Name").addRule(new BeanPropertySetterRule("name"));
    forPattern("*/Criterion/Description").addRule(new BeanPropertySetterRule("description"));

  }
};

DigesterLoader loader = DigesterLoader.newLoader(rules);
Digester digester = loader.newDigester();

DecisionNode dn = digester.parse(...);