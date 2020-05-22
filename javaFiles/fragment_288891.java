sendCommandAsync("USER anonymous", 
    new DefaultPromise<>().addListener(
        (Future<String> f) -> {
            String response = f.get();
            if (response.startWidth("331")) {
                // do something
            }
            // etc
        }
    )
);