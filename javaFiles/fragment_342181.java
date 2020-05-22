public static void main(String[] args) throws IOException {
    Map<Device, List<String[]>> devices = Files
      .lines(new File("./apple.txt").toPath())
      .map(l -> l.split(", "))
      .collect(Collectors.groupingBy(Example::classify));

    Iphone[] iphones = devices.get(Device.IPHONE).stream()
      .map(toIphone())
      .toArray(Iphone[]::new);
    Ipad[] ipads = devices.get(Device.IPAD).stream()
      .map(toIpad())
      .toArray(Ipad[]::new);
  }