StringBuilder dataBuilder = new StringBuilder(); 
Iterator<DatagramPacket> queueIter = queue.iterator();
while(queueIter.hasNext()) {
  DatagramPacket next = queueIter.next();
  System.out.println("1: This prints.");
  System.out.println("2: This doesn't: " + new String(next.getData()));
  int start = (new String(next.getData())).indexOf("\r\n") + "\r\n".length();
  dataBuilder.append(new String(next.getData()).substring(start));
}
data = dataBuilder.toString();