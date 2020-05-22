// count the occurrences of all keywords in the different strings
int[] counts = new int[strings.length];
for (String keyword : keywords) {
     for (Integer index : keyword2stringId.get(keyword)) {
         if (index != null) {
             counts[index]++;
         }
     }
}

// find the string that has the highest number of keywords
int maxCount = 0; 
int maxIndex = -1;
for (int i = 0; i < counts.length; i++) {
    if (counts[i] > maxCount) {
        maxCount = counts[i];
        maxIndex = i;
    }
}

// return the highest ranked string or 
// 'null' if no matching document was found
if (maxIndex == -1) {
    return null;
} else {
    return strings[maxIndex];
}