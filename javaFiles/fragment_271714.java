class Kreis {
    float _x, _y;
    int  _r, _g, _b;
    float radius=50;

    Kreis(float x, float y, int r, int g, int b ) {
        this._x = x;
        this._y = y;
        this._r = r;
        this._g = g;
        this._b = b;
    }

    float X() { return _x; }
    float Y() { return _y; }

    void show() {
        fill(_r, _g, _b);
        noStroke();
        ellipse(_x, _y, radius, radius);
    }
}