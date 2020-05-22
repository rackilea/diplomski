final ArrayList<String> filteredOutputList = new ArrayList<>();
for (String string1 : list_output) {
    boolean stringIsContainedInOtherString = false;
    for (String string2 : list_output) {
        if(!string2.equals(string1) && string2.contains(string1)) {
                stringIsContainedInOtherString = true;
                break;
        }
    }
    if(!stringIsContainedInOtherString && !filteredOutputList.contains(string1)) {
        filteredOutputList.add(string1);
    }
}

for(String filteredOutput: filteredOutputList)
    System.out.println(filteredOutput);