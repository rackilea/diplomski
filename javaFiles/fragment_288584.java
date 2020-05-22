@OneToOne(mappedBy = "father", cascade = CascadeType.ALL)
 @JoinColum("fater_id")
 public AbstractNode getLeaftNode() {
     return leaftNode;
 }

 @OneToOne(mappedBy = "father", cascade = CascadeType.ALL)
 @JoinColum("fater_id")
 public AbstractNode getRightNode() {
     return rightNode;
 }