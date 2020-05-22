public World createWorld(String levelClassName, WorldListener listener) throws Exception
{
    Class<?> clazz = Class.forName(name);
    Constructor<World> ctor = (Constructor<World>) clazz.getConstructor(WorldListener.class);
    World world = ctor.newInstance(listener);

    return world;
}