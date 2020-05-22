btnA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(ActivityA.this, ActivityB.class);
                    i.putExtra("isAnswerCorrect",true);
                    startActivity(i);
                }
            });