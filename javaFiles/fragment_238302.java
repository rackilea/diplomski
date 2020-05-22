// Number of states with estimated population increase in 2011
int x = 0;
// al = arrayList.subList(6,56);
for (int i = 5; i < popList.size(); i++) {
    if(i == 56) break;
    PopulationRecord pr1 = popList.get(i);
    if (pr1.getPopch2011() > 0) {
        x++;
    }
}
System.out.println("Number of states with estimated population increase in 2011 is " + n);