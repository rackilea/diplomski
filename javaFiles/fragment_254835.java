for (int donor : mmap.keySet()) {
  Map<Integer, Long> patientMap = mmap.get(donor);
  if (patientMap.size() < 2) {
    continue; // no duplicates
  }
  // *** your code here ***
}