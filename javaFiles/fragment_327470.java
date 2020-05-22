OrderService subject = new DefaultOrderService();
OrderService orderService = (OrderService) Proxy.newProxyInstance(
         this.getClass().getClassLoader(),
            new Class<?>[]{OrderService.class},
            (proxy, method, args) -> {
                try {
                    System.out.println("Before method");
                    return method.invoke(subject, args);
                }
                finally {
                    System.out.println("After method");
                }
            }
        );
System.out.println(orderService.getClass());
orderService.getOrder(10);