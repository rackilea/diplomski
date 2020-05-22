import java.util.Arrays;  // must be imported
int[] priorities = {sleepPriority, eatPriority, recreationPriority};
Arrays.sort(priorities);
for (int i=priorities.length-1; 0<=i; i--) {
    int priority = priorities[i];
    if (priority == sleepingPriority) { sleep(); }
    if (priority == eatingPriority) { eat(); }
    if (priority == recreationPriority) { watchTv(); }
}