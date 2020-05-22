public class Security {

    private List<String> words = new ArrayList<String>();

    {
        words.add("drop");
        words.add("delete");
        words.add("truncate");
        words.add("remove");
    }

    public Void check(User user, ProceedingJoinPoint pjp){
        for(String word: words){
            if(!user.getUsername().toLowerCase().contains(word)){
                return pjp.proceed();
            }
            return;
        }

    }
}