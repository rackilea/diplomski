for (int i = 0; i < size; i++) {
// your month list is 0-based
    String month = charts_list_HadsM.get(i).month;
    mMonths[i] = month;
    String anx = charts_list_HadsM.get(i).anx;
    String dep = charts_list_HadsM.get(i).dep;


// Make entries index 0-based, too
    e1.add(new Entry(i, Integer.parseInt(anx)));
    e2.add(new Entry(i, Integer.parseInt(dep)));
}