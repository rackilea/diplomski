cartViewHolder.counterButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
        @Override
        public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
            Order order = listData.get(i);
            order.setQuantity(String.valueOf(newValue));
            new Database(cartActivity).updateCart(order);
            calculate();
        }
    })