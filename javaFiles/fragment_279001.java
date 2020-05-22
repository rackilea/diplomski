List<Path> resultSet = Files.walk(rootDir)
                            .filter(matcher::matches)
                            .collect(Collectors.toList());
if(resultSet.size() > 0){
    resultSet.forEach(Start::modify);
}else {
    // do something else   
}