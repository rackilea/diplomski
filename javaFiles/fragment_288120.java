@Controller
public class CustomErrorController implements ErrorController {

    @SuppressWarnings("finally")
    @RequestMapping("/error")
    public String error(Model model, Principal user) {
        try {
            model.addAttribute("sorryMessage", "Özür Dileriz " + user.getName() + " bir hata ile karşılaştık");
            model.addAttribute("weArentWrong",
                    "Belki sen hata yaptın belki biz. Lütfen Linke tıklayarak başlangıca geri dön.");
        } catch (NullPointerException a) {

        } finally {
            return "error";

        }
    }

    @Override
    public String getErrorPath() {
        // TODO Auto-generated method stub
        return null;
    }

}