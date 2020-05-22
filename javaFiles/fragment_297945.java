int k = 0;
for (i = 0; i < array.size()-k; i++) {
            if (array.get(i).isConsumido()) {
                ItemCultural item = array.remove(i);
                array.add(item);
                k++;
                i--;
            }
}