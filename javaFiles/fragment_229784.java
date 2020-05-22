# Create container with java preinstalled
FROM openjdk:8

# Create app directory
VOLUME /tmp

# Handle Arguments
ARG JAR_FILE
ARG ENV_NAME
ARG DRIVER_FILE

# Environment
ENV SPRING_PROFILES_ACTIVE=${ENV_NAME}
RUN echo ${ENV_NAME}

# Fingerprint Driver
RUN apt-get update -y
RUN apt-get install -y expect
COPY ${DRIVER_FILE} driver.tar.gz
COPY driver-install.exp driver-install.exp
RUN tar -xzf driver.tar.gz
RUN /driver-install.exp

# Copy app source
COPY ${JAR_FILE} app.jar
COPY application.yml application.yml

# Run the server
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.config.location=application.yml","-jar","app.jar"]