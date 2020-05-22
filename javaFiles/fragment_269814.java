for ( Occupant oneOccupant : allOccupants)
{
    if("A".equals(oneOccupant.getStringRepresentation()))
    {
        Animal animal = (Animal) oneOccupant;
        player.reduceStamina(animal.getDanger());
    }
}