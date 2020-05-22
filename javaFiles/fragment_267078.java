Vector<Thread> joined = new Vector<Thread>();
for(int i=0;i<threadList.length;i++) {
  if(threadList[i].isAlive() && !joined.contains(threadList[i])){ 
     threadList[i].join(0);
     joined.add(threadList[i]);
  }
}