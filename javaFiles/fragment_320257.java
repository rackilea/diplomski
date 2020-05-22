class SimpleWordList {

   private ArrayList<String> wordListA = new ArrayList<String>();
   private ArrayList<String> wordListB = new ArrayList<String>();
   private ArrayList<String> wordListC = new ArrayList<String>();
   private File currentFile = null;
   private WordPair wordPair;

   // note the assignment constructor
   public SimpleWordList(WordPair wordPair) {
      this.wordPair = wordPair;
   }