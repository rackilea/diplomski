// casingchange-aeiouaeiou-takesexcess-spaces
System.out.println(slugify("CaSiNgChAnGe áéíóúâêîôû   takesexcess    spaces  "));
// these-are-good-special-characters-sic
System.out.println(slugify("These are good Special Characters šíč"));
// some-exceptions-123-aeiou
System.out.println(slugify(" some exceptions ¥123  ã~e~iõ~u!@#$%¨&*() "));
// gonna-accomplish-yadda
System.out.println(slugify("gonna accomplish, yadda, 완수하다, 소양양)이 있는 "));