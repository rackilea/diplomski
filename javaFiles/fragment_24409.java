@Override
public int hashCode() {
    return left.hashCode()
         ^ right.hashCode()
         ^ lookupArtist.hashCode();
}