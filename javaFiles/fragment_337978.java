Monitor mon = null;   

for(int i =0; i < 1000; i++){
  //Part1
  mon = MonitorFactory.start("Point 1");
  Thread.sleep(2);
  mon.stop();     

  //Part2
  mon = MonitorFactory.start("Point 2");
  mon.stop();
}

System.out.println(MonitorFactory.getMonitor("Point 1").toString());
System.out.println(MonitorFactory.getMonitor("Point 2").toString());