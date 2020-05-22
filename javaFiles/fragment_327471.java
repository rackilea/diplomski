DefaultOrderService subject = new DefaultOrderService();
Enhancer enhancer = new Enhancer();
enhancer.setSuperclass(DefaultOrderService.class);
enhancer.setCallback((InvocationHandler) (obj, method, args) -> {
   try {
      System.out.println("Before method");
      return method.invoke(subject, args);
   } 
   finally {
      System.out.println("After method");
   }
});

OrderService orderService = (OrderService) enhancer.create();
System.out.println(orderService.getClass());
orderService.getOrder(10);