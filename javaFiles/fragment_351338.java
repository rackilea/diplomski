for(int j=0; j<pCount*pcCount; j+=pcCount) //<--- j+=pcCount here, not j++
{
    for(int k=0; k<pcCount; k++)
    {
        String pcName = "Piece " + allocation();
        pPieces[j+k] = new Piece(k,pcName,1);
    }
}