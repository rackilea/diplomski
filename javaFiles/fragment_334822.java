String s = "/downloadAPK/D:/coinFiles/Coin-v1.1.8.apk";

    // find first index of /
    int index =s.indexOf("/");

    // find second index of /        
    index=s.indexOf("/", index+1);

    // fetch substring from second index+1 of /
    System.out.println(s.substring(index+1));