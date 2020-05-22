private MyClass(Integer userId, Integer otherId) {
 {
    this.userId = userId;
    this.otherId = otherId;
  }
}
public static  MyClass getInstance(Integer userId, Integer otherId) 
  if(!userId.equals(otherId)){
    return new MyClass(userId,otherId);
  }

  return null;
}