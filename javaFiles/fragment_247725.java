Map<String, Collection<String>> map = 
    new CaseInsensitiveForwardingMap<Collection<String>>();
Multimap<String, String> caseInsensitiveMultiMap = 
    Multimaps.newMultimap(map, new Supplier<Collection<String>>(){

      @Override
      public Collection<String> get(){ return Sets.newHashSet(); }

  });