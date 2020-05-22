public Class User{
  int id;
  Set<Conversation> conversations;
}

public class Conversation{
  int id;
  Set<User> parcipitants;
}