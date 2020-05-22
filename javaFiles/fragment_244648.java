Task<Integer> threadOne = new Task<Integer>(){
    @Override
    protected Integer call() throws Exception{

      while(itemName < 130){
            final int finalValue = itemName++;
            Platform.runLater(() ->  {
                listOptions.add(String.valueOf(itemName));
                label.setText("Generating: " + finalValue);
            });
            Thread.sleep(100);
        }
        label.setText("Thread 1 finished");
        return itemName;
    }
};