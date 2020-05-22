if(Files.walk(rootDir).anyMatch(matcher::matches)) {
         Files.walk(rootDir)
              .filter(matcher::matches)
              .forEach(Start::modify);
}else {
        // do something else    
}