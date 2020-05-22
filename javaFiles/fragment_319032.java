@JoinTable(name = "MyData_foo",
 joinColumns = {
  @JoinColumn(name = "a_id1", referencedColumnName = "id1"), 
  @JoinColumn(name = "a_id2", referencedColumnName = "id2") 
}, 
inverseJoinColumns = {
  @JoinColumn(name = "b_id1", referencedColumnName = "id1"),
  @JoinColumn(name = "b_id2", referencedColumnName = "id2")
})
)