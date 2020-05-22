public void writeToFile(List<Aluno> objectList) {
   String data = objectList
                   .stream()
                   .map(obj -> obj.toString())
                   .collect(Collectors.joining("\n"));

   Files.write(Paths.get("utilizadores_objetos.txt"),
               data.toByte(StandardCharsets.UTF_8),
               StandardOpenOption.CREATE, 
               StandardOpenOption.TRUNCATE_EXISTING);
}