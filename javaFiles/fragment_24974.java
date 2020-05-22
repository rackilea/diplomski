public class GameDAO {
    ....
    public Collection<Game> gamesForTeam(Team t) {
         ....
         Query q = session.createQuery("FROM Game WHERE team1 = :team OR team2 = :team");
         q.setParameter("team", t);
         return q.list();
    }
}