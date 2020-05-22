public class LoginData {
   private final List<TopicBean> topics;
   private final List<UserRoleBean> roles;

   public LoginData(List<TopicBean> topics, List<UserRoleBean> roles) {
     this.topics = topics;
     this.roles = roles;
   }

   public List<TopicBean> getTopics() { return topics; }
   public List<UserRoleBean> getRoles() { return roles; }   }
}