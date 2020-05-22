void updateRotation()
{
    if (rotateByPosition)
    {
        Vector2 rotationVector = new Vector2(position.x - prevPosition.x, position.y - prevPosition.y);
        rotationRad = rotationVector.angleRad();
        rotationDeg = rotationRad * MathUtils.radiansToDegrees;
    }
}