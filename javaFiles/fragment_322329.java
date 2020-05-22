Symbol[][] t = new Symbol[][this.table.length];
for (int i = 0; i < t.length; i++)
{
    t[i] = new Symbol[this.table[i].length];
    for (int j = 0; j < t[i].length; j++)
    {
        // Here I am sharing the Symbol objects between the two arrays.
        // If you do not want that, define your own way to copy or clone the object.
        t[i][j] = this.table[i][j];
    }
}