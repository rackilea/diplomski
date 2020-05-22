if(Gdx.input.isTouched()){
    if(rectangle.contains(Gdx.input.getX(), Gdx.input.getY())){
        openHighscore();
    } else{
        game.setScreen(new GameScreen(game));
        dispose();
    }
}