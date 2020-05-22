public static void main(String[] args) {
    InternetDomainName top = 
        InternetDomainName.from("keyupgrade.spaceforupdate.download").topPrivateDomain();

    System.out.println(top);
  }