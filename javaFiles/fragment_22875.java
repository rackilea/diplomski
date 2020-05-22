@Override
public void setMaxSpeed(int maxSpeed)
{
    if (maxSpeed > 5)
        throw new SomeException();

    super.setMaxSpeed(maxSpeed);
}