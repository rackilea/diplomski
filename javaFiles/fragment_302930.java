domain Java;

  nationalize_literal(s1:literal_string):
    " \s1 " -> "Language.getString1(\s1 )";

  nationalize_single_concatenation(s1:literal_string,s2:term):
    " \s1 + \s2 " -> "Language.getString1(\s1) + \s2"; 

  nationalize_double_concatenation(s1:literal_string,s2:term,s3:literal_string): 
      " \s1 + \s2 + \s3 " -> 
      "Language.getString3(\generate_template1\(\s1 + "{1}" +\s3\, s2);"
   if IsNotLiteral(s2);