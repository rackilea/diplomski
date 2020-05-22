@RequestMapping(value = "/uploadFiles.html", method = RequestMethod.POST)
public ModelAndView save(@ModelAttribute Token token, @ModelAttribute("uploadForm")    FileUpload fileUpload) 
{
    List<MultipartFile> files = fileUpload.getFiles();

    List<String> fileNames = new ArrayList<String>();

    if(files != null && files.size() > 0)
    {
        for(MultipartFile file : files)
        {
            if(!file.isEmpty())
            {
                fileNames.add(file.getOriginalFilename());
            logger.info("Got file with name: " + file.getOriginalFilename());
            }
        }

        logger.info("Total filenames: " + fileNames.size());
    }

    ModelAndView mav = new ModelAndView("etl/EtlUploadSuccess");
    mav.addObject("files",fileNames);
    mav.addObject("token",token);
    return mav;
}