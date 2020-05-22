while(!this.isInterrupted())
{
    if (!removeListElementIfPossible())
    {
        break;
    }
}