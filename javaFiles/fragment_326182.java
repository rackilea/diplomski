if (increament < listOfFlags.size()-1) {
                increament++;
            }
            else{
                Intent resultAl = new Intent(BirdQuiz.this, Result.class);
                resultAl.putExtra("Correct", correct);
                resultAl.putExtra("Result", result);
                resultAl.putExtra("Wrong", wrong);
                startActivity(resultAl);
                finish();
            }