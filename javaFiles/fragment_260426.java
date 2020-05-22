@RequestMapping("/order/A1234/2")
    public String processOrder() {
        System.out.println("process order");
        orderService.processOrder("A1233", 2);
        return "redirect:/product";
    }