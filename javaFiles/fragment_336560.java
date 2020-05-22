public void SetScore(int score)
{
    if(score<0)
    {
        highScore.setVisible(false);
        lockImage.setVisible(true);
    }
    else
    {
        highScore.setVisible(true);
        highScore.setText(Integer.toString(score));
        highScore.validate();
        lockImage.setVisible(false);
    }
}