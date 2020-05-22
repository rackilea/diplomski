{
 ....
 getHash hashThread =  new getHash(this);
 hashThread.execute(new String[] {"http://www.full.path/to/the/file.hash"});
 return; // ok now we just have to wait for it to finish ... can't read it until then
}

// Separate callback method
public void onHashComplete(String hash) {

   if(hash != null && !hash.equals(localHash)) {
      ....
   }
   ....
 }