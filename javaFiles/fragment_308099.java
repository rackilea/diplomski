public class OwnIterator implements Iterator 
{
    private Iterator<Integer> occurrencesItr;

    public OwnIterator(String toCheck, String[] validPair) {
        // build regex to search for every item in validPair
        Matcher[] matchValidPair = new Matcher[validPair.length];
        for (int i = 0 ; i < validPair.length ; i++) {
            String regex = 
                    "(" +    // start capturing group
                    "\\Q" +  // quote entire input string so it is not interpreted as regex
                    validPair[i] +  // this is what we are looking for, duhh 
                    "\\E" +  // end quote
                    ")" ;    // end capturing group
            Pattern p = Pattern.compile(regex);
            matchValidPair[i] = p.matcher(toCheck);
        }
        // do the search, saving found occurrences in list
        List<Integer> occurrences = new ArrayList<>();
        for (int i = 0 ; i < matchValidPair.length ; i++) {
            while (matchValidPair[i].find()) {
                occurrences.add(matchValidPair[i].start(0)+1);  // +1 if you want index to start at 1 
            }
        }
        // sort the list 
        Collections.sort(occurrences);
        occurrencesItr = occurrences.iterator();
    }

    @Override
    public boolean hasNext()
    {
        return occurrencesItr.hasNext();
    }

    @Override
    public Object next()
    {
        return occurrencesItr.next();
    }
}