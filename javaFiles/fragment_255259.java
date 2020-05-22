if (word.length() >= histogram.length)
{
....
}
else // introduced
if (word.length() < histogram.length){
        histogram[word.length()]++;
}