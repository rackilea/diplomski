@Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurerAdapter() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/robotpart/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");


                }
            };
        }