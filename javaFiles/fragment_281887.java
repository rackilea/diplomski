public void move()
{
    if(this.direction == "North")
    {           
        setPosition(getPosition().getPosToNorth(this.speed));
    }
}