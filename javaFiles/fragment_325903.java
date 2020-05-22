class Category {
  @Id @Column(name="CATEGORY_ID)
  Long id;

  @ManyToOne // or @OneToOne if you really insist
  @JoinColumn(name="RULE_ID)
  Rule rule;
)