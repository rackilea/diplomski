public static List<Question> getQuestions(List<Question> availableQuestions,
                                      int quizDifficulty, int numberOfQuestion)
{
    if(availableQuestions.size() < numberOfQuestion)
        throw NotEnoughQuestionsException();

    List<Question> questions = new ArrayList<Question>(numberOfQuestion);
    Map<Integer, List<Question>> map = new HashMap<Integer, List<Question>>();
    for(int i = 1; i <= 10; i++) map.put(i, new ArrayList<Question>());
    for(Question question : availableQuestions) 
    map.get(question.getDifficulty()).add(question);

    int L1 = map.get(1).size(); // number of questions with level 1
    int L2 = map.get(2).size();
    int L3 = map.get(3).size();
    int L4 = map.get(4).size();
    int L5 = map.get(5).size();
    int L6 = map.get(6).size();
    int L7 = map.get(7).size();
    int L8 = map.get(8).size();
    int L9 = map.get(9).size();
    int L10 = map.get(10).size();

    final int L1_TO_L8  = 0;
    final int L1_TO_L9  = 1;
    final int L1_TO_L10 = 2;
    final int L2_TO_L9  = 3;
    final int L2_TO_L10 = 4;
    final int L3_TO_L10 = 5;

    int status;

    if(difficulty == 0) // Easy (level 1 to level 8)
    {
        int missing = questionsCount - (L1+L2+L3+L4+L5+L6+L7+L8);
        if(missing > 0) // not enough questions in L1 through L8
        {
            if(missing - L9 > 0) // we must include all the level
            {
                status = L1_TO_L10;
            }
            else // enough questions in L1 through L9
            {
                status = L1_TO_L9;
            }
        }
        else // enough questions in L1 through L8
        {
            status = L1_TO_L8;
        }
    }
    else if(difficulty == 2) // Hard (level 3 to level 10)
    {
        int missing = questionsCount - (L3+L4+L5+L6+L7+L8+L9+L10);
        if(missing > 0) // not enough questions in L3 through L10
        {
            if(missing - L2 > 0) // we must include all the level
            {
                status = L1_TO_L10;
            }
            else // enough questions in L2 through L10
            {
                status = L2_TO_L10;
            }
        }
        else // enough questions in L3 through L10
        {
            status = L3_TO_L10;
        }
    }
    else /*if(difficulty == 1)*/ // Normal (level 2 to level 9)
    {
        int missing = questionsCount - (L2+L3+L4+L5+L6+L7+L8+L9);
        if(missing > 0) // not enough questions in L2 through L9
        {
            if(missing - L1 > 0) // we must include all the level
            {
                status = L1_TO_L10;
            }
            else // enough questions in L1 through L9
            {
                status = L1_TO_L9;
            }
        }
        else // enough questions in L2 through L9
        {
            status = L2_TO_L9;
        }
    }

    if(status == L1_TO_L8) // Look into level 1 through level 8 only
    {
        int q = 0;
        for(int level = 1; level <= 8 && q < numberOfQuestion; level += 8 * q <= numberOfQuestion * level? 0 : 1)
        {
            if(level == 1)
            {
                if(check(readyQuestionsList, map, 1)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
            }
            else if(level == 2)
            {
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 1)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
            }
            else if(level == 3)
            {
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 1)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
            }
            else if(level == 4)
            {
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 1)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
            }
            else if(level == 5)
            {
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 1)){q++; continue;}
            }
            else if(level == 6)
            {
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 1)){q++; continue;}
            }
            else if(level == 7)
            {
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 1)){q++; continue;}
            }
            else if(level == 8)
            {
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 1)){q++; continue;}
            }
        }
    }
    else if(status == L1_TO_L9)
    {
        int q = 0;
        for(int level = 1; level <= 9 && q < numberOfQuestion; level += 9 * q <= numberOfQuestion * level? 0 : 1)
        {
            if(level == 1)
            {
                if(check(readyQuestionsList, map, 1)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
            }
            else if(level == 2)
            {
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 1)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
            }
            else if(level == 3)
            {
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 1)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
            }
            else if(level == 4)
            {
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 1)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
            }
            else if(level == 5)
            {
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 1)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
            }
            else if(level == 6)
            {
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 1)){q++; continue;}
            }
            else if(level == 7)
            {
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 1)){q++; continue;}
            }
            else if(level == 8)
            {
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 1)){q++; continue;}
            }
            else if(level == 9)
            {
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 1)){q++; continue;}
            }
        }
    }
    else if(status == L2_TO_L9)
    {
        int q = 0;
        for(int level = 2; level <= 9 && q < numberOfQuestion; level += 9 * q <= numberOfQuestion * level? 0 : 1)
        {
            if(level == 2)
            {
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
            }
            else if(level == 3)
            {
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
            }
            else if(level == 4)
            {
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
            }
            else if(level == 5)
            {
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
            }
            else if(level == 6)
            {
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
            }
            else if(level == 7)
            {
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
            }
            else if(level == 8)
            {
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
            }
            else if(level == 9)
            {
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
            }
        }
    }
    else if(status == L2_TO_L10)
    {
        int q = 0;
        for(int level = 2; level <= 10 && q < numberOfQuestion; level += 10 * q <= numberOfQuestion * level? 0 : 1)
        {
            if(level == 2)
            {
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 10)){q++; continue;}
            }
            else if(level == 3)
            {
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 10)){q++; continue;}
            }
            else if(level == 4)
            {
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 10)){q++; continue;}
            }
            else if(level == 5)
            {
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 10)){q++; continue;}
            }
            else if(level == 6)
            {
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
                if(check(readyQuestionsList, map, 10)){q++; continue;}
            }
            else if(level == 7)
            {
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 10)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
            }
            else if(level == 8)
            {
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 10)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
            }
            else if(level == 9)
            {
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 10)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
            }
            else if(level == 10)
            {
                if(check(readyQuestionsList, map, 10)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 2)){q++; continue;}
            }
        }
    }
    else if(status == L3_TO_L10)
    {
        int q = 0;
        for(int level = 3; level <= 10 && q < numberOfQuestion; level += 10 * q <= numberOfQuestion * level? 0 : 1)
        {
            if(level == 3)
            {
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 10)){q++; continue;}
            }
            else if(level == 4)
            {
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 10)){q++; continue;}
            }
            else if(level == 5)
            {
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 10)){q++; continue;}
            }
            else if(level == 6)
            {
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 10)){q++; continue;}
            }
            else if(level == 7)
            {
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 10)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
            }
            else if(level == 8)
            {
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 10)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
            }
            else if(level == 9)
            {
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 10)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
            }
            else if(level == 10)
            {
                if(check(readyQuestionsList, map, 10)){q++; continue;}
                if(check(readyQuestionsList, map, 9)){q++; continue;}
                if(check(readyQuestionsList, map, 8)){q++; continue;}
                if(check(readyQuestionsList, map, 7)){q++; continue;}
                if(check(readyQuestionsList, map, 6)){q++; continue;}
                if(check(readyQuestionsList, map, 5)){q++; continue;}
                if(check(readyQuestionsList, map, 4)){q++; continue;}
                if(check(readyQuestionsList, map, 3)){q++; continue;}
            }
        }
    }
    else /*if(status == L1_TO_L10)*/
    {
        // same idea is implemented here
    }
    return questions;
}

private boolean check(List<Question> readyQuestionsList, Map<Integer, List<Question>> map, int level)
{
    if(map.get(level).size() > 0 && map.get(level).get(0) != null)
    {
        readyQuestionsList.add(map.get(level).remove(0));
        return true;
    }
    return false;
}