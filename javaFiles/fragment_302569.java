hitbox = new Rectangle(){
    public boolean overlaps (Rectangle r) {
        float left = Math.min(x, x + width);
        float right = Math.max(x, x + width);
        float top = Math.min(y, y + height);
        float bottom = Math.max(y, y + height);
        float left2 = Math.min(r.x, r.x + r.width);
        float right2 = Math.max(r.x, r.x + r.width);
        float top2 = Math.min(r.y, r.y + r.height);
        float bottom2 = Math.max(r.y, r.y + r.height);
        return left < right2 && right > left2 && top < bottom2 && bottom > top2;
    }
};