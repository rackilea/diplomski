new SpringApplication(ExampleApplication.class) {

        @Override
        public void setListeners(Collection<? extends ApplicationListener<?>> listeners) {
            super.setListeners(listeners
                    .stream()
                    .filter((listener) -> !(listener instanceof UnwantedListener))
                    .collect(Collectors.toList()));
        }

    }.run(args);