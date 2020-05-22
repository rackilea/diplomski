@ProxyFor(UserEntity.class)
interface UserEntityProxy extends EntityProxy {
  String getAttribute1();
  void setAttribute1(String s);
}

@ProxyFor(AdminEntity.class)
interface AdminEntityProxy extends UserEntityProxy {
  String getAttribute2();
  void setAttribute2(String s);
}