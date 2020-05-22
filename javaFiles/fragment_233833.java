public Bits(Core p, UUID u)
{
    this.plugin = p;
    this.u = u;
    this.MySQL = new PlayerSQL(plugin);
}