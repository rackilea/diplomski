static final String labelRegex="^\\s*\\w+$";
static final Pattern labelPattern = Pattern.compile(labelRegex, Pattern.MULTILINE);
Matcher labelMatcher = labelPattern.matcher("");

static final String stateRegex = "([10] )+[10]\\s+";
static final String statesRegex = "("+stateRegex+")+";
static final Pattern statesPattern = Pattern.compile(statesRegex, Pattern.MULTILINE);
Matcher stateMatcher = statesPattern.matcher("");

static final String chunkRegex = "(?="+labelRegex+")";
static final Pattern chunkPattern = Pattern.compile(chunkRegex,Pattern.MULTILINE);
Scanner chunkScan;

public void setSource(File source) {
    if(source!=null && source.canRead()) {
     try {
      chunkScan = new Scanner(new BufferedReader(new FileReader(source)));
      chunkScan.useDelimiter(chunkPattern);
     } catch (IOException e) {
      e.printStackTrace();
     }
    }
}

public Map<String, List<GraphState>> next(int n) {
 Map<String,List<GraphState>> result = new LinkedHashMap<String,List<GraphState>>(n);
  String chunk, rows;
  int i=0;
  while (chunkScan.hasNext()&&i++<n) {
    chunk = chunkScan.next().trim();
    labelMatcher.reset(chunk);
    stateMatcher.reset(chunk);
   if (labelMatcher.find()&&stateMatcher.find()) {
    rows = stateMatcher.group().replace(" ", "");
    result.put(labelMatcher.group(), rowsToList(rows.split("\\n")));
   }
  }
  return result;
}