rule fold_true_ifTE(s: statement, t:statement): statement->statement =
 "  if (true) then \s else \t " ->  " \s ";

 rule fold_false_ifTE(s: statement, t:statement): statement->statement =
 "  if (false) then \s else \t " ->  " \t ";

 rule fold_constants_add(x:NUMBER,y:NUMBER):sum -> sum =
 " \x + \y " -> " \Add\(\x\,\y\)";