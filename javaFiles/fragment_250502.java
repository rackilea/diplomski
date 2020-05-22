@Controller
@RequestMapping("/bus/topologie")
public class TopologieController {
    private static final String VIEW_TOPOLOGIE = "topologie";

    @RequestMapping(method = RequestMethod.POST, params = { "genererCle" })
    public String genererClePost(final Topologie topologie, final RedirectAttributes redirectAttributes, @RequestParam("genererCle") final String genererCle, final Model model)
        throws IOException {
        redirectAttributes.addAttribute("genererCle", genererCle);
        return "redirect:/bus/topologie";
    }

    @RequestMapping(method = RequestMethod.GET, params = { "genererCle" })
    public String genererCleGet(final Topologie topologie, final Model model)
        throws IOException {
        cadreService.genererCle(topologie);
        return VIEW_TOPOLOGIE;
    }