@Override
  public Principal getUserPrincipal()
  {
    if (this.user == null)
    {
      return realRequest.getUserPrincipal();
    }

    // return a forged GenericPrincipal
    return new GenericPrincipal(user, "", roles);
  }