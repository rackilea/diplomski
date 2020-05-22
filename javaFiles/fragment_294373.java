//getPeaks() returns the same map in both cases.
// In other words : sample.get(1).getPeaks() == sample.get(2).getPeaks()
System.out.println(sample.get(1).getPeaks().toString());    
System.out.println(sample.get(2).getPeaks().toString());

// This is equivalent to
Map<String, Map<String, String>> myStaticMap = Sample.getPeaks();
System.out.println(myStaticMap.toString());    
System.out.println(myStaticMap.toString());