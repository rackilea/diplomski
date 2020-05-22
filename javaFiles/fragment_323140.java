ball = new MenuBall(this);
bot1 = new MenuBot1(this);
ball.setMenuBot1(bot1);
bot1.setMenuBall(ball);
thread = new MenuThread(this, bot1, ball);
(...)