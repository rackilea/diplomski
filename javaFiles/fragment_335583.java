String pattern="PREVIMER_F2-MARS3D-MENOR1200_20140809T0000Z.nc";
int start=pattern.lastIndexOf("_") + 1;
int end=pattern.lastIndexOf(".");
if(start != 0 && end != -1 && end > start) {
     System.out.println(pattern.substring(start,end);
}