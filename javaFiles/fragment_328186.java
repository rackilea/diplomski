// If the current value from the left list is smaller than the middle
// element, then get the next element from the left list
while(opisByProductId.get(i).getProductId() < middle){
    i++;
    if(i > high){ // <- high instead of j
        i = high; // <- high instead of j
        break;
    }
}

// If the current value from the right list is larger than the middle
// element, then get the next element from the right list
while(opisByProductId.get(j).getProductId() > middle){
    j--;
    if(j < low){ // <- low instead of i
        j = low; // <- low instead of i
        break;
    }
}