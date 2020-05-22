if (listOfFlags.get(increament).get(position).get(1) == 1) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(BirdQuiz.this, "");
                correct += 1;
                result += 100;
            }
            else {
                ViewDialog1 alert1 = new ViewDialog1();
                alert1.showDialog(BirdQuiz.this, "");
                wrong +=1;
            }