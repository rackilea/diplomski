String str = "ISL-1027" +
            "\n" +
            "20:13:02:22:00:76";
    String[] arr= str.split("\n");
    System.out.println("Bluetooth  Name: "+arr[0]);
    System.out.println("MAC address: "+arr[1]);