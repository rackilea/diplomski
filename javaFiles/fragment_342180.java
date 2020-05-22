private static Function<String[], Iphone> toIphone() {
    return line -> {
      Iphone iphone = new Iphone();
      iphone.setModel(Device.IPHONE.toString() + line[0].split(" ")[1]);
      iphone.setScreenSize(line[1]);
      iphone.setProcessor(line[2]);
      iphone.setSimType(line[3]);
      iphone.setColor(line[4]);
      iphone.setROM(line[5]);
      iphone.setIs3DTouch(line[6]);
      iphone.setPrice(line[7]);
      return iphone;
    };
  }

  private static Function<String[], Ipad> toIpad() {
    return line -> {
      Ipad ipad = new Ipad();
      ipad.setModel(Device.IPAD.toString() + line[0].split(" ")[1]);
      ipad.setScreenSize(line[1]);
      ipad.setProcessor(line[2]);
      ipad.setIsWifi(line[3]);
      ipad.setColor(line[4]);
      ipad.setMemory(line[5]);
      ipad.setPrice(line[6]);
      return ipad;
    };
  }