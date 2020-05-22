private static void readStreamOfLinesUsingFiles() throws IOException
{
    Stream<String> lines = Files.lines(Paths.get("c:/temp", "data.txt"));
    Optional<String> hasPassword = lines.filter(s -> s.contains("password")).findFirst();
    if(hasPassword.isPresent()){
        System.out.println(hasPassword.get());
    }
    //Close the stream and it's underlying file as well
    lines.close();
}