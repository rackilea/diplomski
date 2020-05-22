for(final Animal animal : animalList){
    executor.submit(new Runnable(){
        public void run() {
            animal.feed();
        }
    });
}