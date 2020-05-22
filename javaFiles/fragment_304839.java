public static <T extends Question> QuestionListFragment<T> newInstance(Bundle args) {
        // Create a new instance of QuestionListFragment<? extends Question>
        QuestionListFragment<T> fragment = new QuestionListFragment<T>();

        // Set the arguments
        fragment.setArguments(args);

        // Return the Fragment
        return fragment;
    }