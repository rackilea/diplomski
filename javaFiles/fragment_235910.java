public interface UserService extends Service {

  ServiceCall<NotUsed, PSequence<User>> getUsers(Optional<String> filter);

  @Override
  default Descriptor descriptor() {
    return Service.named("user-service").withCalls(
      Service.restCall(Method.GET, "/api/users?filter", this::getUsers)
    ).withAutoAcl(true);
  }
}