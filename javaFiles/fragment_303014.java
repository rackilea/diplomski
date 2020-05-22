Soldier first = new Soldier(0);
Soldier curr = first;
for (int i =1; n<N; i++) {
   curr.next = new Soldier(i);
   curr = curr.next;
}