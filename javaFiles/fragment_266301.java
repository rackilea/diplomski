trait HasPassword {
  def password(): String
}

class User extends HasPassword {
  override def password(): String = "generating a password (default)"
}

trait SecurePassword extends HasPassword {
  override def password(): String = "generating a password (non-default)"
}

new User with SecurePassword