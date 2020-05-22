// this method need to show your exchange page
@GetMapping("/exchange")
public String handleGetRegisterRequest(
        @ModelAttribute Exchange exchange) { // your object (Thymeleaf will receive this to bind with the parameters you pass)
    return "exchange"; // the name of your page which contains the exchange informations
}