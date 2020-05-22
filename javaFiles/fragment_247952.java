class Question {
    String text
    Answer answer
    Genre genre

    static mapping = {
        table 'my_schema_1.question'
    }
}

class Answer {
    String text

    static mapping = {
        table 'my_schema_1.answer'
    }
}

class Genre {
    String name

    static mapping = {
        table 'my_schema_2.genre'
    }
}