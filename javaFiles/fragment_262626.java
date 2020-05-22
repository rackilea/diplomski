jhipster-registry:
    extends:
        file: jhipster-registry.yml
        service: jhipster-registry
    mem_limit: 512m
    ports:
        - 8761:8761
    networks:
      - backend
    volumes:
      - ${PWD}/Ping.jar:/Ping.jar
    healthcheck:
      test: ["CMD", "java", "-jar", "/Ping.jar", "localhost", "8761"]
      interval: 30s
      retries: 20