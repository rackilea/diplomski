public void diminuer() {
    if(squares.size() > 0)
    {
        Rectangle obj = squares.get(squares.size() - 1);
        addSquare(obj.x * 10, obj.y * 10, obj.width * 10, obj.height * 10);
    }
}