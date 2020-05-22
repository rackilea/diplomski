yourArray.sort(new YourNameComparator());

class YourNameComparator implements Comparator<YourNameClass> {
    int compare(YourNameClass y1, YourNameClass y2) {
        return y1.getName().compareTo(y2.getName());
    }
}