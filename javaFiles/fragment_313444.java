@RequestMapping("/upload.action")
public String upload(@RequestParam(value = "file") MultipartFile file,
        HttpServletResponse response,Model model)
{
    //Controller logic...
}