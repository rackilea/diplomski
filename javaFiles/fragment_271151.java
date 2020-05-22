int time = 6;
private CountDownTimer countDownTimer;


private void timeDownTimer() {
        countDownTimer = new CountDownTimer(6000, 1000) {

            public void onTick(long millisUntilFinished) {
                tvTimer.setText("0:" + checkDigit(time));
                time--;

            }

            public void onFinish() {
                tvTimer.setText("Time finished");
                countDownTimer.cancel();
                fechUserPoints();
            }


        }.start();
    }

    public String checkDigit(int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }

    private void fetchUserPoints() {

        reference.child(mId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                prevPoints = dataSnapshot.child("points").getValue().toString();
                int prePoints = Integer.valueOf(prevPoints);
                String newPoints = String.valueOf(prePoints + ADDED_POINTS);

                reference.child(mId).child("points").setValue(newPoints).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getContext(), "Process is successful", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }