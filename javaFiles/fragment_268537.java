GuestInfo info = vm.getGuest(); //(vm means VirtualMachine object.)
GuestDiskInfo[] dInfos = info.getDisk();
if (dInfos != null) {
  System.out.println("Disk Info");
  for (GuestDiskInfo dInfo : dInfos) {
    System.out.println(" Capacity(GB):"+dInfo.getCapacity()/1024/1024/1024);
    System.out.println(" Free(GB):"+dInfo.getFreeSpace()/1024/1024/1024);
    System.out.println(" Disk Path:"+dInfo.getDiskPath());
    System.out.println("============");
  }
}