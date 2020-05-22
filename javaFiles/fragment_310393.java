public void testAddContacts() throws Exception{
            File f = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
            System.out.println(f.isFile()+"  "+f.getName()+f.exists());
            FileInputStream fi1 = new FileInputStream(f);
            FileInputStream fi2 = new FileInputStream(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg"));
            MockMultipartFile fstmp = new MockMultipartFile("upload", f.getName(), "multipart/form-data",fi1);
            MockMultipartFile secmp = new MockMultipartFile("upload", "Tulips.jpg","multipart/form-data",fi2); 
            MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
            mockMvc.perform(MockMvcRequestBuilders.fileUpload("/AddContacts")                
                    .file(fstmp)
                    .file(secmp)
                    .param("name","abc").param("email","abc@gmail.com").param("phone", "1234567890"))               
                    .andExpect(status().isOk());
    }