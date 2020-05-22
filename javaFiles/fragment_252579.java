for (int i = 0; i < q.questionbank.length; ++i) {
        q.Question = input(q.questionbank[i]);

        answer1 = false;
        while (!answer1) {

            if (q.Question.equals(a.correctans) || (q.Question.equals(a.impossibleans) || (q.Question.equals(a.wrongans)))) {
                score = printquiz(answer, score, q.Question);
                answer1 = true;
            } else {
                print("Not a Valid Answer, please try again\n");
            }
        }
    }