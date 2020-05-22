// search for parens  + digits
    Pattern p=Pattern.compile("\\((\\d+)");
    Matcher m=p.matcher(userEntry);
    // where to search from in the string
    int st=0;
    while (m.find(st))  {

            String d = m.group(1);
            // get new start index
            st=m.end();
            int i = Integer.parseInt(d);
            int even_check = i % 2; // This is to get remainders
            // prime checks
            ...
            // now we need to search for comma + digits
            p=Pattern.compile(",(\\d+)");
            m=p.matcher(userEntry);
    }
    primeOrNot += ")";
    System.out.println(primeOrNot);