@Inject
public KlasseA(ClassZ classZ, ClassY classY)
{
    classZ = classZ;
    classY = classY;
}

@Inject
public KlasseB(ClassZ classZ, KlasseA klasseA, @Assisted ClassYFactory classyFactory)
{
    classZ = classZ;
    classY = classyFactory.create(klasseA);
    klasseA = klasseA;
}