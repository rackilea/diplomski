public void onStep()
{
    for (Wall wall : wall_items) // Assuming wall_items is iterable
    {
        // Do not modify walls behind or above projectile
        if (wall.x > this.x == false) continue;
        if (wall.y > this.y == false) continue; // Skip and continue loop

        wall.width = this.width + this.velocity_x;
        wall.height = this.height + this.velocity_y;
    }

    this.x += this.velocity_x;
    this.y += this.velocity_y;
}