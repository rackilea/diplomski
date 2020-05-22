@ElementCollection
@CollectionTable(
  name = "task_properties",
  joinColumns = {
    @JoinColumn(
      name = "task_id"
    )
  },
  foreignKey = @ForeignKey(
    foreignKeyDefinition = "FOREIGN KEY (task_id) REFERENCES Task"
  )
)
private Set<String> properties;