@Entity
class Settings {
  @Id int id = 0;
  boolean showFriendsList = false;
  String marketingText = "You'll love it";
  byte[] mainImage = ...; 
}