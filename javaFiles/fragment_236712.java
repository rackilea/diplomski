for(int noOfQuestToSet = 1; noOfQuestToSet<=noOfQuest; noOfQuestToSet++)
            {
                int i = noOfQuestToSet -1;
                questionArr = new String[noOfQuestToSet];
                String appendToIndex = String.valueOf(noOfQuestToSet);
                questionArr[i] = props.getProperty("Q"+appendToIndex);

                String[] answers= new String[noOfQuestToSet];
                do
                {
                    Scanner scnAnswer = new Scanner(System.in).useDelimiter("\\n");
                    System.out.println(questionArr[i]);
                    answers[i] = scnAnswer.next();
                    if(iCheckAnswerforNull(answers, i)==true)
                    {
                        System.out.println("Please ensure you enter an answer to each question");
                        continue;
                    }
                    System.out.println(finalMess);
                    //EmailSend sendEmail = new EmailSend();
                //  EmailSend.sendEmail(userName, answers);
                    break;
                }
                while(true);
            }