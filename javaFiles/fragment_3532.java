@RequestMapping( value = "/{prePath:[a-zA-Z]+}/module/{file_id}" )
public String getModule( @PathVariable( "file_id" )
int fileId, Model model, RedirectAttributes redirectAttributes)
{
    try
    {
        FileBean fileBean = new FileDAO().getFileInfo( fileId );
        if( fileBean != null )
        {
            //model.addAttribute( "fileBean", fileBean );
            redirectAttributes.addFlashAttribute("fileBean", fileBean);
            return "redirect:../module.do";
        }
    }
    catch( Exception e )
    {
         e.printStackTrace();
    }

    return "redirect:../module.do?error";
}