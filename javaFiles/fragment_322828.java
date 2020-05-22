FROM java:8

COPY CheckSum.jar /

ENV JARDIR=/usr/myjars

RUN mkdir -p ${JARDIR}

COPY PaytmChecksum.jar ${JARDIR}

ENTRYPOINT java -jar /CheckSum.jar