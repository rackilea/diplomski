@ActionMapping(params = "ConController=showPayment")
        public ModelAndView showPayment(ActionResponse response, @ModelAttribute("conPayForm") ConsiPayForm consiForm, Model model) {
                PaymentDetailsResponse paymentDetailsResponse = stand.getDet();

                   ViewDet view = stand.getView();
                    ...
                    PaymentDetails paymentDetails = paymentDetailsResponse.getPayDetails();
                    ....        
                    model.addAttribute("paymentDetails", paymentDetails);
                    ModelAndView modelAndView = new ModelAndView("view"); //as per view resolver
                    modelAndView.addObject("",colorsList);
                    modelAndView.addObject("design",designList);
                    return modelAndView;
                }
            }