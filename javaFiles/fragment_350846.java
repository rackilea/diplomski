Map<String, String> flatMap = new HashMap<>();

    orders.forEach(order -> {
        String k = order.orderId;
        String values = order.executionId;

        for (String v : values.split(",")) {
            flatMap.put(v, k);
        }

    });