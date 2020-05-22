@RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView userRegister(@ModelAttribute("user") @Valid User user, BindingResult result, ModelMap model, @RequestParam("fileData") MultipartFile fileData) throws Exception {
        if (!fileData.isEmpty() && fileData != null) {                
            byte[] bytes = fileData.getBytes();
            user.setFileName(fileData.getOriginalFilename());
            user.setImageFile(bytes);
            byte[] encodeBase64 = Base64.encodeBase64(bytes);
            String base64Encoded = new String(encodeBase64, "UTF-8");
            user.setBase64image(base64encoded);
        }
    }