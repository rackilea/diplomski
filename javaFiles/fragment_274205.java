synchronized(entities)
{
    for (Entity e : entities) {
        g.fillRect(x, y, w, h);
    }
}