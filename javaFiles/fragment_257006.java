@RequestMapping("/test")
    public String test() throws IOException {
        return StringUtils.modifyReturnJson("123");
        //return "123"; ajax works fine
//        return 123; //ajax works fine
//        return "abc";  //ajax parsererror
    }