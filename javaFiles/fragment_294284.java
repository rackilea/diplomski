String str = ",Share %,\"Date Purchased\",Display Name,Address,Phone,Fax,Mobile,Email,";

Matcher beginningFileMatcher = Pattern.compile(FILE_BEGINNING_PATTERN).matcher(str);

// find() method starts at the beginning of this matcher's region, or, if
// a previous invocation of the method was successful and the matcher has
// not since been reset, at the first character not matched by the previous
// match.
//

int count = 0;
while (beginningFileMatcher.find()) { // find not match, we need beginningFileMatcher.reset() but its not 
    if (count == 0)
        System.out.println("Regex match!");
    // thread-safe.
    count++;
    System.out.println("COUNT ++++++++++++++ :" + count);
}

//try another way.
String s = ",Share %,\"Date Purchased\",Display Name,Address,Phone,Fax,Mobile,Email,";
Pattern beginningFilePattern = Pattern.compile(FILE_BEGINNING_PATTERN);
Matcher matcher = beginningFilePattern.matcher(s);

int countCount = 0;
while (matcher.find()) { // make sure to use matcher object
    if (countCount == 0)
        System.out.println("Thread-safe regex match!");
    countCount++;
    System.out.println("COUNT ++++++++++++++ :" + countCount);
}