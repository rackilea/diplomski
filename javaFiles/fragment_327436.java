public Tile(Color _color, Color _border)
{
    color = _color;
    border = _border;
    setBorder(BorderFactory.createLineBorder(border, 2));
}