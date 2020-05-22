else if (event.getX() > 1150 && event.getX() < 1300 && event.getY() > 550 && event.getY() < 700)
{
    System.out.println("Schuss");
    final ArrayList<Shot> positions = game.shot(100, 45, canvas);
    YourActivity.this.runOnUiThread(new Runnable() {
        public void run() {
            for (int i = 0; i < positions.size(); i++)
            {
                game.setCurrentShot(positions.get(i));
                Log.d("YourApp", "i = "+i);
                canvas.invalidate();
            }
        }
    });
}