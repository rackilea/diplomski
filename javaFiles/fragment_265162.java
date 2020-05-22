@RequestMapping(value = "/echofile",method = RequestMethod.POST)
        public @ResponseBody HashMap<String, Object> echoFile(HttpServletRequest  request,
                HttpServletResponse response ,  @ModelAttribute("uploadedFile") UploadedFile upldfile) throws Exception {
         HashMap<String, Object> map = new HashMap<String, Object>();

         if(request instanceof MultipartHttpServletRequest){

             InputStream inputStream = null;
                OutputStream outputStream = null;
              // MultipartFile multipartFile = request.getFile("file");

                MultipartFile file = upldfile.getFile();
                String fileName = file.getOriginalFilename();
                System.out.println("vcvvvvvvvv"+fileName);
                upldfile.setFile(file);

                Long size = file.getSize();
                String contentType = file.getContentType();

                InputStream stream = file.getInputStream();
                byte[] bytes = IOUtils.toByteArray(stream);


                map.put("fileoriginalsize", size);
                map.put("contenttype", contentType);
                map.put("base64", new String(Base64Utils.encode(bytes)));

                try {


                    inputStream = file.getInputStream();

                       File newFile = new File("E:/Java_Project/EmployeeRegistrationForm/src/main/webapp/resources/image/"+ fileName);
                       if (!newFile.exists()) {
                        newFile.createNewFile();
                       }
                       outputStream = new FileOutputStream(newFile);
                       int read = 0;
                      byte[] byt = new byte[1024];

                       while ((read = inputStream.read(byt)) != -1) {
                        outputStream.write(byt, 0, read);
                       }
                      } catch (IOException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                      }


         }
         return map; 


         }