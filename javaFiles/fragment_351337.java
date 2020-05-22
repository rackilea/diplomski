for(int j=0; j<pCount; j++) //pCount = 4
{
    for(int k=0; k<pcCount; k++) //pcCount = 2
    {
        String pcName = "Piece " + (allocation());
        pPieces[j+k] = new Piece(k,pcName,1);
    }
}