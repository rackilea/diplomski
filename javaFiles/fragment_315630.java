boolean found = false;
for (whatever-your-loop-should-look-like) {
     if (the-current-element-meets-the-condition) {
         found = true;
         break;
     }
}
if (!found) {
     whatever-action-you-take-when-it-isn't-found;
}