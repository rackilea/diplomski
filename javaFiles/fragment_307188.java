FROM anapsix/alpine-java:8u172b11_server-jre
ARG project_file_name
ENV PROJECT_FILE=${project_file_name}

MAINTAINER jim
COPY src/${project_file_name} /home/${project_file_name}
CMD java -jar /home/${PROJECT_FILE}