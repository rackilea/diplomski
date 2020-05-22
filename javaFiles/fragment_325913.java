@Id
@GeneratedValue(strategy = IDENTITY)
@Column(name = "pid", unique = true, nullable = false)
public Integer getPid() {
   return this.pid;
}