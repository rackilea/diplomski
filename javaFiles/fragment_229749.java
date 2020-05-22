private ExecutorService executorService = Executors.newSingleThreadExecutor();

private Task<Boolean> createBuyDishTask(int dishId, double cost) {
    return new Task<Boolean>() {
        @Override
        protected Boolean call() throws Exception {
            return Datasource.getInstance().insertDishSale(dishId, cost);
        }
    };
}

public void orderFood(ActionEvent event){
    if (event.getSource() == salmon) {
        executorService.execute(createBuyDishTask(1, 4.99));
   }
}