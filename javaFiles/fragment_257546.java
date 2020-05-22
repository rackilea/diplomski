public boolean contains(int x, int y) {
        if ((x < this.x + this.width) && (x > this.x-this.width) && (y < this.y + this.height) && (y > this.y-this.height))
            return true;
        else
            return false;
    }