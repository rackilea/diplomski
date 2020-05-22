@Entity
public class GameMembership {
   Team team;
   Game game;
   int gamePosition; // If tracking Team 1 vs Team 2 matters to you
}