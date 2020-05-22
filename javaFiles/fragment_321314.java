final static long EXPIRED_MILLIS = 1000 * 10; // ten seconds
final static Pattern REQUEST_PATTERN = Pattern.compile("(.* )(<< \\d{4} )(REQUEST COUNTER=\")(\\d)(\")");
final static Pattern RESPONSE_PATTERN = Pattern.compile("(.* )(<< \\d{4} )(RESPONSE COUNTER=\")(\\d)(\")");
final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yy/MM/dd-HH:mm:ss.SSS");

List<String> getExpiredCounterList(File file) throws Exception {
    Map<String,Long> requestMap = new HashMap<>();
    List<String> expiredCounterList = new ArrayList<>();

    try( FileReader fileReader = new FileReader(file);
         BufferedReader buffReader = new BufferedReader(fileReader) )
    {
        String line;
        while((line = buffReader.readLine()) != null) {
            Matcher requestMatcher = REQUEST_PATTERN.matcher(line);
            if(requestMatcher.matches()) {
                addRequestToMap(line, requestMatcher, requestMap);
                continue;
            }

            Matcher responseMatcher = RESPONSE_PATTERN.matcher(line);
            if(requestMatcher.matches()) {
                String expiredCounter = checkIfExpiredAndRemoveFromMap(line, responseMatcher, requestMap);
                if(expiredCounter != null)
                    expiredCounterList.add(expiredCounter);
            }
        }
    }
    return expiredCounterList;
}

void addRequestToMap(String request, Matcher requestMatcher, Map<String,Long> requestMap) {
    String counter = getCounter(request, requestMatcher, 4);
    long date = getDate(request, requestMatcher, 1);
    requestMap.put(counter, date);
}

String checkIfExpiredAndRemoveFromMap(String response, Matcher responseMatcher, Map<String,Long> requestMap) {
    String counter = getCounter(response, responseMatcher, 4);
    if( requestMap.containKey(counter) ) {
        long date = getDate(response, responseMatcher, 1);
        long elapsedMillis = date - requestMap.remove(counter);
        if(elapsedMillis > EXPIRED_MILLIS)
            return counter;
     }
     return null;
}

String getCounter(String line, Matcher matcher, int group) {
    return line.substring(matcher.start(group), matcher.end(group));
}

long getDate(String line, Matcher matcher, int group) throws ParseException {
    return DATE_FORMAT.parse(line.substring(matcher.start(group), matcher.end(group))).getTime();
}