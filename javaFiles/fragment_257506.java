public class Question extends Model {
    // (...)
    public static final Finder<Integer, Question> find =
                                            new Finder<>(Question.class);

    public static List<Question> all() {
        return find.all();  
    }

}

val questions = Question.all
// or
val questions = Question.find.all