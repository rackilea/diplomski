public int Value()
{
    switch(rank) {
    case "A":
        return 11;
    case "K":
    case "Q":
    case "J":
        return 10;
    default:
        return Integer.parseInt(rank);
}