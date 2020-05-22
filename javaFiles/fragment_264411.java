@RequestMapping(value = "/schedulebatch",method = 
RequestMethod.POST,params="insertData")
public @ResponseBody String addBatch(@RequestPart("upfile") MultipartFile upfile) throws Exception {  
    if(!upfile.isEmpty()){
        System.out.println("test1");
    }
}