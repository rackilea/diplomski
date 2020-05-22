Monitor mon1 = null;   
Monitor mon2 = null;     

for(int i =0; i < 1000; i++){
  //Part1
  mon1 = MonitorFactory.start("Point 1");
  Thread.sleep(2);
  mon1.stop();     

  //Part2
  mon2 = MonitorFactory.start("Point 2");
  mon2.stop();
}

System.out.println(mon1.toString());
System.out.println(mon2.toString());