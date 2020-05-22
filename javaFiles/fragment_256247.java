while ((dataByte = fis.read())!=-1) {
if (32 <= dataByte && dataByte <= 126 )
{
   count++;
sb.append((char) dataByte);
if (0 == (count % 64)) {
sb.append("\n");count=0;
}

}  
}