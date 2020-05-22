Validator<Integer> checkingRule = new Rule(new Checker1(), new CheckerN());
CompositeResult result = checkingRule.validate(yourParameter);
if (result.isOk()) 
    System.out.println("All validations passed");
else
    System.out.println(result.getFailedCount() + " validations failed");