// char $ needs to be escaped because it has different meaning in regular expressions
// <$
String leftDelimiter = "(<\\$)";
// $>
String rightDelimiter = "(\\$>)";

// leftDelimiter | rightDelimiter
// when used to split a string would split it each time it detected those two patters
// and it would also split it in the case I dont want them to split it
// and that is "\<$foo$>" case - when they are "escaped" in the string

// to solve it we can try to match our leftDelimiter only if char \ isnt before it

// matches all [$ that dont start with \
String fixedLeftDelimiter = "(?<!\\\\)"+leftDelimiter;

// the problem presents itself with the rightDelimiter because it needs to check 
// whether there had been a leftDelimiter before it that has been escaped


// the following takes care of that

// matches all $> that dont have a <$ starting with \
String betterRightDelimiter = "(?<!\\\\"+leftDelimiter+whatCanBeInTags+rightDelimiter;

// whatCanBeInTags is everything that can be in out tags besides $ sign
// we are using {0,"+(Integer.MAX_VALUE-3)+"}? instead of *? because of a limitation
// of number of characters put in lookbehind assertion
String whatCanBeInTags = "[^\\$]{0,"+(Integer.MAX_VALUE-3)+"}?)";