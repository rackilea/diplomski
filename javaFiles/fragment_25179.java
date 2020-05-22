@RequestMapping(value = "/upload" , method = RequestMethod.POST)
public void upload(HttpServletRequest request) {

    //org.springframework.web.multipart.MultipartHttpServletRequest
    MultipartHttpServletRequest mRequest;
    mRequest = (MultipartHttpServletRequest) request;

    Iterator<String> itr = mRequest.getFileNames();
    while (itr.hasNext()) {
        //org.springframework.web.multipart.MultipartFile
        MultipartFile mFile = mRequest.getFile(itr.next());
        String fileName = mFile.getOriginalFilename();
        System.out.println("*****"+ fileName);

        //To copy the file to a specific location in machine.
        File file = new File('path/to/new/location');
        FileCopyUtils.copy(mFile.getBytes(), file); //This will copy the file to the specific location.
    }
}