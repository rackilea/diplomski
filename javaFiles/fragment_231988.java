while ((line = br.readLine()) != null) {
    RacingCyclist obj = new RacingCyclist();
    obj.parseLine(line);
    cyclistList.add(obj);
    System.out.println(line);
}