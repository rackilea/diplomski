@UiField (provided=true) SuggestBox searchEntriesSuggestBox;
 static MultiWordSuggestOracle oracle = null; 

 public MenuBar() {
   if (oracle == null) {
     oracle = new MultiWordSuggestOracle();
   }
   searchEntriesSuggestBox = new SuggestBox(oracle);
   initWidget(uiBinder.createAndBindUi(this));
 }

 public static void loadUserEntries(Collection<String> entries){
   oracle.clear();
   oracle.addAll(entries);
 }