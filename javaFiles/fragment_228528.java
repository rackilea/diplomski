public class Lottery{
    public boolean isWinner(ArrayList<?> user, ArrayList<?> lotto){

            if(user == null || lotto == null)
                return false;
            if(user.size() == 0 || lotto.size() == 0)
                return false;

            return lotto.containsAll(user);
        }
}