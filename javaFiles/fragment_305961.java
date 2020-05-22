Expression: 
     Expression1 [AssignmentOperator Expression1]

Expression1: 
     Expression2 [Expression1Rest]

Expression1Rest: 
     ? Expression : Expression1

Expression2:
     Expression3 [Expression2Rest]

Expression2Rest:
     { InfixOp Expression3 }
     instanceof Type


InfixOp: 
     || 
     &&
     // and many other operators