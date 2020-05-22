@Override
public String toString()
{
    final StringBuilder sb = new StringBuilder();
    final String newline = System.getProperty("line.separator"); 
    for (final Room room : map) sb.append(room.toString()).append(newline);
    return sb.toString();
}