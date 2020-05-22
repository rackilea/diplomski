public class Identifier {
  long id; // should be a 'String', actually
  String name;
}

public class Doc {
  private Identifier identifier;
  private String docType
}

public class DocReview {
  private Identifier identifier;
  private String status;
  private String comment;
}