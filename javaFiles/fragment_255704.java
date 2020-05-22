new java.util.Timer(true).schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            PlayerControl.MoveForward = false;
                        }
                    },
                    100
            );