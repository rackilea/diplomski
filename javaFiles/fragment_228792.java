class MYComparator implements Comparator<Artwork> {
  List<Long> artworkIds;
  MYComparator (List<Long> artworkIds) {
   this.artworkIds = artworkIds;
 }
 @Override
 public int compare(Artwork o1, Artwork o2) {
   int index1= artworkIds.indexOf(o1.getId());
   int index2 = artworkIds.indexOf(o2.getId());
   return (i1 < i2) ? -1 : ((i1 > i2) ? 1 : 0) ;
}