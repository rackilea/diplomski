// psuedo-code
final Map<String, Integer> stringFreq = ....; // it doesn't matter what kind of impl you use

// collect the String vs frequency in stringFreq

Map<String, Integer> result = new TreeMap<String, Integer>(stringFreq, 
        new Comparator<String> {
        @Override
            public int compare(String a, String b) {
                int aFreq = stringFreq.get(a);
                int bFreq = stringFreq.get(b);
                return (aFreq==bFreq)?a.compareTo(b) : (aFreq-bFreq);
            }
        });


// result should have data sorted by frequency, and then the string value