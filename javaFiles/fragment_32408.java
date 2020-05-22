Class Response {
  boolean success;
  ArrayList<File> files;
  ResponseError error;
  [...]
}

Class File {
  String name;
  long size;
  [...]
}

Class ResponseError {
  int errorCode;
  String systemMessage;
  String userMessage;
  [...]
}