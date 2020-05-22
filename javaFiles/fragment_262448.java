String str = "shyam,ram,sasi,solai";
List<String> yourList = Arrays.asList(str.split(","));
yourList.stream().forEach((item) -> {
    System.out.println(item);
        });
    }