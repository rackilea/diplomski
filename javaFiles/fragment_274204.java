synchronized(entities)
{
    for (Survivor s : toRemove) {
        survivors.remove(s);
    }

    for (Zombie z : toAdd) {
        zombies.add(z);
    }
}