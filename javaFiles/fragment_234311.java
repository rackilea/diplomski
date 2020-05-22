final String control = "<userActionRequiredCode>0</userActionRequiredCode>";
final String test = "<userActionRequiredCode xsi:nil=\"1\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>";

Diff myDiff = DiffBuilder.compare(Input.fromString(control))
                         .withTest(Input.fromString(test))
                         .build();
System.out.println(myDiff.toString());