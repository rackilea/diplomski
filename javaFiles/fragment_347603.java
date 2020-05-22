Files.lines(Paths.get(fileName))
     .map(s->{
              int index = s.indexOf("EXCHANGEID=");
              return index>=0?s.substring(index+11,index+15):null;
         })
     .filter(Objects::nonNull)
     .forEach(System.out::println);