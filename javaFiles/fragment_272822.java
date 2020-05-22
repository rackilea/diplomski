private void equalityCheck(int newColor)
{
        ...
        if (model.isValidPosition(x, y+1) && model.getColor(x, y + 1) == newColor && !model.isCaptured(x, y + 1))
        {
            model.capture(x, y + 1);
            dots.push(model.get(x, y + 1));
        }