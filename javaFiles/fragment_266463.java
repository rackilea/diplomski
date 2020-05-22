int size = 0
Point result = default
while(result == default)
   result = searchRectangleBoundary(size++, pointClicked)

function Point searchRectangleBoundary(int size, Point centre)
{
    point p = {centre.X - size, centre.Y - size}
    for i in 0 to and including size
    {
        if(view_set[p.X + i][p.Y]) return { p.X + i, p.Y}
        if(view_set[p.X][p.Y + i]) return { p.X, p.Y + i}
        if(view_set[p.X + i][p.Y + size]) return { p.X + i, p.Y + size}
        if(view_set[p.X + size][p.Y + i]) return { p.X + size, p.Y + i}
    }
    return default
}