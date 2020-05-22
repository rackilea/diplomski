private class TAdapter extends KeyAdapter{
    ...
    @Override
    public void keyPressed(KeyEvent e){
        fish.keyReleased(e);  <-- Whoops - should be keyPressed
    }
}