JButton prev, next, curr;
Component[] arr = getComponents();

for(int i=1;i<arr.length-1;i++) {
    if (yourcondition == true) {
        curr = (JButton) arr[i];
        prev = (JButton) arr[i-1];
        next = (JButton) arr[i+1];
    }
}