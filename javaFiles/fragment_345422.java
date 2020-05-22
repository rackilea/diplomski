List<Header> headerList = new LinkedList<Header>();
    for (int i = 0; i < 5; i++) {


        Header header11 = new Header("MyHeader"+ i, "Something"+ i);
         headerList.add(header11);

    }

Headers headers = new Headers(headerList);