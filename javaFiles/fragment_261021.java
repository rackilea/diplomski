for each line in CSV-file {
  split line by ',' and store in array
  check first item in array =>
    if array[0].equals("diode") => create diode object from array of size 4
    if array[0].equals("capacitor") => create capacitor object from array of size 5
    ...
  store created object in a List<>
}