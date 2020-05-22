PasswordExpirationPolicy policy = passwordExpirationPolicyFactory().createDefault();
boolean mustChangePassword = user.passwordMustBeChanged(policy);


//class User
public boolean passwordMustBeChanged(PasswordExpirationPolicy policy) {
    return policy.hasExpired(currentDate, this.lastPasswordChangeDate);
}