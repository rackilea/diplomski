Predictor.every(3).second().doDid(new Job<Void>() {
                    @Override
                    public Void run() {
                        textView.setText("Your text");
                        return null;
                    }
                });