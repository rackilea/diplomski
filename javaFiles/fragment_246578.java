@RequestMapping(value = "endpoint", method = RequestMethod.POST)
private @ResponseBody String getFormData(FormInput userInput, HttpServletRequest request, final ModelMap model) {

        String userInput1 = userInput.getInputOne();
        String userInput2 =  userInput.getInputTwo();
        String userInput3 = userInput.getInputThree();;
        String userInput4 = userInput.getInputFour();
        String userInput5 = userInput.getInputFive();

        return "success";

}