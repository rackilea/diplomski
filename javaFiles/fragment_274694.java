private int appId;

private String lname;

private String fname;

@ManyToOne
@JoinColumn(name="appId", referencedColumnName="appId", nullable = false, insertable=false, updatable=false)
@NotFound(action = NotFoundAction.IGNORE)
Private Document document

//getters and setter generated