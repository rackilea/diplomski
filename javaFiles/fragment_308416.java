boolean isColliding(Entity other) {
if (center.y + hlY < other.center.y - other.hlY ||
    center.y - hlY > other.center.y + other.hlY)
    return false;

Rectangle r1 = { center.x - hlX, center.z - hlZ, lX, lZ };
Rectangle r2 = { other.center.x - other.hlX, other.center.z - other.hlZ, other.lX, other.lZ };

return r1.intersects(r2);
}