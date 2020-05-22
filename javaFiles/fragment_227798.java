String userId = "";
testUserId(userId); // false - Correct as we test an empty string with an at-least-one-char regex
userId = "æÆbBcCćĆčČçďĎǳǲdzsDzs";
testUserId(userId); // false - Correct as we only match 1 character string, others fail
userId = "test123";
testUserId(userId); // false - see above
userId = "abcxyzsd";
testUserId(userId); // false - see above

String zip = "i«♣│axy";
testZip(zip);                    // true - OK, 7-symbol string matches against [...]{0,10} regex
zip = "331fsdfsdfasdfasd02c3";
testZip(zip);                 // false - OK, 21-symbol string does not match a regex that requires only 0 to 10 characters
zip = "331";          
testZip(zip);                // true - OK, 3-symbol string matches against [...]{0,10} regex