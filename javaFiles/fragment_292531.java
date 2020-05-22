if (rHealth == 0) {
                    state = GameState.Dead;
                    Sound.MAIN.stop();
                    Sound.DIE.play();
                }

                if (robot.getCenterY() > 500) {
                    state = GameState.Dead;
                    robot.setCenterY(0);
                    robot.setCenterX(0);
                    Sound.MAIN.stop();
                    Sound.DIE.play();
                }

                if (score == 35) {
                    state = GameState.Win;
                    score = 40;
                    Sound.MAIN.stop();
                    Sound.WIN.play();
                }
            }