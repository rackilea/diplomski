public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:9000");
        }
    };
}