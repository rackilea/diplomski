public int move(int speed, Rectangle bounds) {                
    // Apply the delta
    p.x += speed;
    // Have we passed beyond the right side??
    if (p.x + radius >= (bounds.x + bounds.width)) {                    
        speed *= -1;
        p.x = ((bounds.x + bounds.width) - radius) + speed;                    
    // Have we past beyond the left side??
    } else if (p.x <= bounds.x) {
        speed *= -1;
        p.x = bounds.x + speed;                    
    }
    p.y = bounds.y + (bounds.height - radius) / 2;                
    return speed;                
}