Properties inputSource = new Properties();
inputSource.put("ERROR", "ERROR");
inputSource.put("PRINT", "PRINT");
inputSource.put("&", "&"); // this point input resource error.
inputSource.put("GET", "GET");

System.out.println(inputSource.get("&"));