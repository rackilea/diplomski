int i, j;
for (i = 0, j = 0; i < array1.size() && j < array2.size();) {
    if (array1.get(i) < array2.get(j)) {
        list.add(array1.get(i));
        i++;
    } else {
        list.add(array2.get(j));
        j++;
    }
}

while(i < array1.size()) list.add(array1.get(i++));
while(j < array2.size()) list.add(array2.get(j++));