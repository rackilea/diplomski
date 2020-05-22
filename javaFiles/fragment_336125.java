enum KnowledgeLevel
{
    BEGINNER, ADVANCED, PROFESSIONAL, MASTER;

    static KnowledgeLevel fromUserInput(final int input)
    {
        if (input >= 10) {
            return MASTER;
        }
        else if (input >= 7) {
            return PROFESSIONAL;
        }
        else if (input >= 4) {
            return ADVANCED;
        }
        else {
            return BEGINNER;
        }
    }
}