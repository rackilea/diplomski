public class TrackerChip
{
    GlassPiece linkedGlassPiece;

    public void setGlassPiece(GlassPiece newGlassPiece)
    {
         setGlassPiece(newGlassPiece, true);
    }

    public void setGlassPiece(GlassPiece newGlassPiece, boolean reentrant)
    {
        GlassPiece oldGlassPiece = linkedGlassPiece;

        linkedGlassPiece = newGlassPiece;

        if(reentrant && oldGlassPiece != null)
        {
            oldGlassPiece.setTrackerChip(null, false); //disconnect old GlassPiece
        }

        if(linkedGlassPiece != null && linkedGlassPiece.getTrackerChip() != this)
        {
            linkedGlassPiece.setTrackerChip(this); //update counterpart
        }
    }
}