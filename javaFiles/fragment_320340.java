class Notification {
     @ManyToMany
     @JoinTable(
         name="USER_NOTIFICATION",
         joinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"),
         inverseJoinColumns=@JoinColumn(name="NOTIFICATION_ID", 
         referencedColumnName="ID"))
  private List<User> users;
}