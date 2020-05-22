List<CoordinatesParamas> lCoordinates = new ArrayList<CoordinatesParamas>();

while(sc.hasNextLine()) {
     CoordinatesParamas temp = new CoordinatesParamas();
     String pair = sc.nextLine();
     String[] s = pair.split(" ");
     temp.setLatitude(s[0])
     temp.setLongitude(s[1])
     lCoordinates.add(temp ); 
}