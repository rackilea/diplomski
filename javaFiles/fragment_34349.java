List<Sample> sampleList = ...;
String[] array = new String[sampleList.size()];
int i = 0;
for (Sample sample : sampleList) {
    array[i++] = sample.getContent();
}