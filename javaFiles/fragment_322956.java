public List<Aluno> readFile() throws IOException {
   List<Aluno> list = Files.readAllLines(Paths.get("utilizadores_objetos.txt"))
                      .stream()
                      .filter(s -> !s.trim().isEmpty())
                      .map(s -> new Aluno(s))
                      .collect(Collectors.toList());
   return list;
}