Map<String, String> Result = ...;

// This orders your Result map by key, using String natural order
Map<String, String> ordered = new TreeMap<>(Result);

// Now write the results
BufferedWriter bw = new BufferedWriter(new FileWriter("dicomTagResults.txt"));
ordered.forEach((k, v) -> bw.write(k + v + "\r\n");

bw.close();