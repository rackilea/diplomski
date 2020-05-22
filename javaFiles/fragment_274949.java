@Convert(converter=RoleA.class)
  @Column(name="role_id_a")
  private IRole roleA;

  @Convert(converter=RoleB.class)
  @Column(name="role_id_b")
  private IRole roleB;