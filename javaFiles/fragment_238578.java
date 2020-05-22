@PostMapping("/foo")
    public String showPage(@ModelAttribute("someBean") SomeBean bean, @RequestParam("myParam") Integer myIntegerParam) {

        System.out.println("My param: " + myIntegerParam);
        return "redirect:someOtherPage";
    }