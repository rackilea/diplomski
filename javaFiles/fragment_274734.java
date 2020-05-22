// Questionnaire results
    System.out.println("Survey Results\t\t\t Yes\t No");

    for (int i=0;i<numQuestions;i++) {
            int total = 0;

            for (int j=0;j<PARTICIPANTS;j++)
                    total += answer[j][i];

            int percent = (total * 100) / PARTICIPANTS;

            System.out.println(question[i] + "\t " + percent + "%\t " + (100-percent) + "%");
    }