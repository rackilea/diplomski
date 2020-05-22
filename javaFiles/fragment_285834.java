FROM python:3.6.5

ARG CONTAINER_USER="python"
ARG CONTAINER_UID="1000"

# Will not prompt for questions
ENV DEBIAN_FRONTEND=noninteractive \
    CONTAINER_USER=python \
    CONTAINER_UID=1000

RUN apt update && \
    apt -y upgrade && \
    apt -y install \
      ca-certificates \
      locales \
      tzdata \
      inotify-tools \
      python3-pip \
      groovy && \

    locale-gen en_GB.UTF-8 && \
    dpkg-reconfigure locales && \

    #https://github.com/guard/listen/wiki/Increasing-the-amount-of-inotify-watchers
    printf "fs.inotify.max_user_watches=524288\n" >> /etc/sysctl.conf && \

    useradd -m -u ${CONTAINER_UID} -s /bin/bash ${CONTAINER_USER}

ENV LANG=en_GB.UTF-8 \
    LANGUAGE=en_GB:en \
    LC_ALL=en_GB.UTF-8

USER ${CONTAINER_USER}

RUN pip3 install \
      fSQLAlchemy==1.2.7 \
      pandas==0.23.0 \
      pymongo \
      openpyxl==2.5.3 \
      joblib \
      impyla && \
    pip3 uninstall bson


# pip install will put the executables under ~/.local/bin
ENV PATH=/home/"${CONTAINER_USER}"/.local/bin:$PATH

WORKDIR /home/${CONTAINER_USER}/workspace

ADD . /home/${CONTAINER_USER}/dataeng

EXPOSE 5000

ENTRYPOINT ["python", "/home/python/dateng/_aws/trigger.py"]