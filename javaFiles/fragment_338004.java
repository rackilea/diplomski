public boolean equals(Object otherObject)
{
    Pair aPair = (Pair)otherOject; //--------> ???

    if(aPair.fst.equals(this.fst) && aPair.snd.equals(this.snd))
    {
        return true;
    }
}