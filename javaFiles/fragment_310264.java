public class Rect {
    public int minX;
    public int minY;
    public int maxX;
    public int maxY;

    public Rect() {}

    public Rect(int x, int y, int w, int h) {
        this.minX = x;
        this.minY = y;
        this.maxX = x + w -1;
        this.maxY = y + h -1;
    }

    public boolean Intersect(Rect r) {
        return this.maxX >= r.minX &&
               this.minX <= r.maxX &&
               this.maxY >= r.minY &&
               this.minY <= r.maxY;              
    }

    public Rect GetIntersection(Rect r) {
        Rect i = new Rect();
        if (this.Intersect(r)) {
            i.minX = Math.max(this.minX, r.minX);
            i.minY = Math.max(this.minY, r.minY);
            i.maxX = Math.min(this.maxX, r.maxX);
            i.maxY = Math.min(this.maxY, r.maxY);
        }
        return i;       
   }

   public int GetWidth() {
       return this.maxX - this.minX + 1;   
   }

    public int GetHeight() {
        return this.maxY - this.minY + 1;   
    }

    public void SetPosition(int x, int y) {
        int w = this.GetWidth();
        int h= this.GetHeight();
        this.minX = x;
        this.minY = y;
        this.maxX = x + w -1;
        this.maxY = y + h -1;
    }
}