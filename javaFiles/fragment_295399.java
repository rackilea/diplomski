List elms; // original elements
Heap heap; // heap we store in

for element e in elms:
    push e onto heap
    if heap contains more than 10 elements:
        pop the max element from heap