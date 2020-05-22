for (Question qn : questions) {
            RadioGroup answerGroup = new RadioGroup(this);
            answerGroup.setOrientation(RadioGroup.VERTICAL);
            for (Answer an : qn.getAnswers()) {
                if (qn.getID() == an.getQuestion_id_answer()) {
                    RadioButton answer = new RadioButton(this);
                    answer.setText(an.getAnswer());
                    answerGroup.addView(answer);
                }
            }
            linearLayout.addView(answerGroup);
        }