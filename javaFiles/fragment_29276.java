@RequestMapping(value = "/media/image/upload", method = RequestMethod.POST)
        @ResponseBody
        public Map<String, String> productPictureUploadnew(MultipartHttpServletRequest request, HttpServletResponse response) {
            Map<String, String> resp = new HashMap<>();
            System.out.println("fsasasafsafsafsafsa");
            Iterator<String> itr = request.getFileNames();

            String photoCake = request.getParameter("photoCak");
            File file;
          ----------
           -------
          ----------              

            return resp;
        }