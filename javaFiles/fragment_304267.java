for(int i=0;i<countCard;i++)
{
    for(int j=0;j<countCard -1;j++)
    {
        if(playerHand[j].compareTo(playerHand[j+1]) > 0)
        {
            temp=this.playerHand[j+1];
            this.playerHand[j+1]= this.playerHand[j];
            this.playerHand[j] = temp;
        }
    }
}