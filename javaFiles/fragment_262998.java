for (Iterator<Answer> ans = answers.iterator(); ans.hasNext();){
                Answer ans = ans.next();
                System.out.print(ans.getId());
                System.out.println(": "+ans.getAnswerText());

            }