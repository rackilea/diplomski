Pattern yes = Pattern.compile(".*\\byes\\b.*");
Pattern no = Pattern.compile(".*\\bno\\b.*");
...
bool matchesYes = yes.matcher(input).matches();
bool matchesNo = no.matcher(input).matches();

if (matchesYes == matchesNo) {
    ... //Do "invalid answer" here -
    //we either matched both (true, true) or neither (false, false)
} else if (matchesYes) {
    ... //Do "Yes" here
} else { //Else matches No
    ... //Do "No" here
}