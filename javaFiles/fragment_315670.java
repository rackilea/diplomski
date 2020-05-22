public int compareTo(highScore hs)
{
    if (((Integer)this.guessCount).compareTo(((Integer)hs.guessCount)) > 0)
        return 1;
    else
    {
        if(this.guessCount == hs.guessCount)
        {
          if(this.playerTime > hs.playerTime)
          {
             return 1;
          }
          else
          {
             return -1;
          }
        }

        return -1;
    }
}