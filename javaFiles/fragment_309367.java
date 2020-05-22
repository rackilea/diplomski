String blurredText = text.replaceAll("(?<=\\S) (?=\\S)", ".");
String[] blurredLines = text.split("\r\n?|\n");

int maxRowLength = 0;
for (String blurredLine : blurredLines) {
  maxRowLength = Math.max(maxRowLength, blurredLine.length());
}

int[] columnCounts = new int[maxRowLength];
for (String blurredLine : blurredLines) {
  for (int i = 0, n = blurredLine.length(); i < n; ++i) {
    if (blurredLine.charAt(i) != ' ') { ++columnCounts[i]; } 
  }
}    

// Look for runs of zero of at least length 3.
// Alternatively, you might look for the n longest runs of zeros.
// Alternatively, you might look for runs of length min(columnCounts) to ignore
// horizontal rules.

int minBreakLen = 3;  // A tuning parameter.
List<Integer> breaks = new ArrayList<Integer>();
outer: for (int i = 0; i < maxRowLength - minBreakLen; ++i) {
  if (columnCounts[i] != 0) { continue; }
  int runLength = 1;
  while (i + runLength < maxRowLength && 0 == columnCounts[i + runLength]) {
    ++runLength;
  }
  if (runLength >= minBreakLen) {
    breaks.add(i);
  }
  i += runLength - 1;
}

System.out.println(breaks);