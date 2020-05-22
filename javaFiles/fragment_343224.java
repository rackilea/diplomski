public void fuehreAus(){
    Executors.newSingleThreadExecutor().submit(new Runnable() {
        @Override
        public void run() {
            while(true) {
                Klotz_Array[0].unsichtbar();
                Klotz_Array[1].unsichtbar();
                Klotz_Array[2].unsichtbar();
                ...
            }
        }
    });
}