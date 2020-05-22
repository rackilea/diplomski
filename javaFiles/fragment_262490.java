// semi-formally, APDL seems to define:
// AssignmentExpression     -> QualifiedIdentifier = Expression
// QualifiedIdentifier      -> SPACE+ Identifier SPACE*
// Expression               -> SPACE* Value  //Value is captured as "value"
// Identifier               -> [A-Za-z0-9]*  //Identifier is captured as "identifier"
// Value                    -> [0-9]* (DOT [0-9]*)?

private static final String rValue = "\\d+(\\.\\d*)?";
private static final String rIdentifier = "(?<identifier>\\w+)";
private static final String rQualifiedIdentifier = " +" + rIdentifier + " *";
private static final String rExpression = " *-?(?<value>" + rValue + ")";

private static final String rAssignmentExpression = rQualifiedIdentifier + "=" + rExpression;


@Test
public void when_scanning_using_our_regex(){
    Pattern assignmentPattern = Pattern.compile(rAssignmentExpression);
    Pattern rhsPattern =        Pattern.compile("=" + rExpression);
    Pattern valuePattern =      Pattern.compile(rValue);

    Matcher assignmentMatcher = assignmentPattern.matcher(sourceText);

    StringBuffer output = new StringBuffer();
    int newValue = 20;

    while(assignmentMatcher.find()){
        String assignment = assignmentMatcher.group();
        Matcher rhsMatcher = rhsPattern.matcher(assignment);
        assert rhsMatcher.find() : "couldn't find an RHS in an the assignment: '" + assignment + "'?";
        String oldRhs = rhsMatcher.group();
        Matcher valueMatcher = valuePattern.matcher(oldRhs);
        assert valueMatcher.find() : "couldn't find a value in an RHS: '" + oldRhs + "'?";

        String oldValue = valueMatcher.group();
        String newRhs = oldRhs.replace(oldValue, "" + newValue);
        String newAssignment = assignment.replace(oldRhs, newRhs);

        assignmentMatcher.appendReplacement(output, "" + newAssignment);
    }

    assignmentMatcher.appendTail(output);

    System.out.println(output.toString());

}