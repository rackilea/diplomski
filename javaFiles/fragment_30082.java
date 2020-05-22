Iterator<Pearl> iter = this.pearls.iterator();
while ( iter.hasNext() ) {
   Pearl pearl = iter.next();
   // logic
   iter.remove();
}