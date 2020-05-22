@PostMapping("/upload")
    public void   uploadFile(@Nullable @RequestParam(value = "file",required = false) MultipartFile file,
                                                 @RequestParam(value="input",required = false)String st)
    {
        ObjectMapper om=new ObjectMapper();
       MyInput input =null;
        try {
            input=om.readValue(st,MyInput.class);   //string st -> MyInput input
        } catch (IOException e) {
            e.printStackTrace();
        }
    }