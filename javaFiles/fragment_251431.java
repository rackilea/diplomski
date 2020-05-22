s2 = raf.readUTF();
comparisonArray.add(s2);
 System.out.println("Found in file: "+s2);
for(int j=0; j<20-s2.length();j++){
   raf.readByte();
} 
s3 = raf.readUTF();
comparisonArray.add(s3);
 System.out.println("Found in file: "+s3);
for(int j=0; j<20-s2.length();j++){
   raf.readByte();
}