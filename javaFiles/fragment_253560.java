@RequestMapping(value = "/uploadFile", method = RequestMethod.POST) 
public @ResponseBody ResponseEntity<GenericResponseVO<? extends IServiceVO>> uploadFileHandler(@RequestParam("name") String name, @RequestParam("file") MultipartFile file,HttpServletRequest request, HttpServletResponse response) { 
    if (!file.isEmpty()) { 
        try { 
            byte[] bytes = file.getBytes();     
            // Creating the directory to store file 
            String rootPath = System.getProperty("catalina.home"); 
            File dir = new File(rootPath + File.separator + "tmpFiles"); 
            if (!dir.exists()) 
                dir.mkdirs();     
            // Create the file on server 
            File serverFile = new File(dir.getAbsolutePath() + File.separator + name); 
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile)); 
            stream.write(bytes);
            stream.close(); 
            System.out.println("Server File Location=" + serverFile.getAbsolutePath());
            return null; 
        } catch (Exception e) { 
            return null; 
        } 
    } 
}