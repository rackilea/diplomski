// \b(?:(brown)|(\S+))\b
// 
// Options: Case sensitive; Exact spacing; Dot doesn’t match line breaks; ^$ don’t match at line breaks; Default line breaks
// 
// Assert position at a word boundary (position preceded or followed—but not both—by a Unicode letter, digit, or underscore) «\b»
// Match the regular expression below «(?:(brown)|(\S+))»
//    Match this alternative (attempting the next alternative only if this one fails) «(brown)»
//       Match the regex below and capture its match into backreference number 1 «(brown)»
//          Match the character string “brown” literally (case sensitive) «brown»
//    Or match this alternative (the entire group fails if this one fails to match) «(\S+)»
//       Match the regex below and capture its match into backreference number 2 «(\S+)»
//          Match a single character that is NOT a “whitespace character” (ASCII space, tab, line feed, carriage return, vertical tab, form feed) «\S+»
//             Between one and unlimited times, as many times as possible, giving back as needed (greedy) «+»
// Assert position at a word boundary (position preceded or followed—but not both—by a Unicode letter, digit, or underscore) «\b»