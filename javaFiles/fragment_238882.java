StringBuffer rplcmntBfr = new StringBuffer();
while(pochhammer.find())  {
   pochhammer.appendReplacement(rplcmntBfr, "\\\\pochhammer{" + pochhammer.group(2) + "}{" + pochhammer.group(3) + "}");
}
pochhammer.appendTail(rplcmntBfr);
System.out.println(rplcmntBfr);