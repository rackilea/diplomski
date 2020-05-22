Function<String, List<String>> flines = (String x) -> {
      try{
        Stream<String> streamString = Files.lines(Paths.get(x)); 
        List<String> tmp = streamString.collect(Collectors.toList());
        return tmp;
      }
      catch (IOException e){
        throw new RuntimeIOException(e); 
      }

  };