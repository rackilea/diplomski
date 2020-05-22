for(Game.Color color : Game.Color.values())
{
    if(!(color.ordinal() < numberOfColorsToUse))
        break;
    DrawRectangle(color);
}