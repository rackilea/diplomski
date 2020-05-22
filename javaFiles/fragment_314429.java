public class ParserTest {

  public static void main(String[] args) throws Exception {
    CompilationUnit cu;

    try (FileInputStream in = new FileInputStream("C:\\tmp\\Test.java")) {
      cu = JavaParser.parse(in);
    }

    List<TypeDeclaration> types = cu.getTypes();
    ArrayList<String> parents = new ArrayList<>();

    for (TypeDeclaration typeDeclaration : types) {
      printTypes(typeDeclaration, parents);
    }
  }

  private static void printTypes(BodyDeclaration item, List<String> parents) {
    if (item instanceof TypeDeclaration) {

      TypeDeclaration type = (TypeDeclaration) item;

      System.out.println(getClassName(type.getName(), parents));
      List<BodyDeclaration> members = type.getMembers();

      List<String> cloneOfParents = new ArrayList<>(parents);
      cloneOfParents.add(type.getName());

      for (BodyDeclaration bodyDeclaration : members) {
        printTypes(bodyDeclaration, cloneOfParents);
      }
    }
  }

  private static String getClassName(String name, List<String> parents) {
    StringBuilder builder = new StringBuilder();
    for (String string : parents) {
      builder.append(string);
      builder.append(".");
    }

    return builder.append(name).toString();
  }
}