public REDTeleporter(WorldServer worldIn)
{
    super(worldIn);
    this.worldServerInstance = worldIn;
    this.random = new Random(worldIn.getSeed());
}