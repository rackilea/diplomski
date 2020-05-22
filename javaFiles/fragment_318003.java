#!/bin/bash
release_type=$1
version=$2
if [[ ${release_type} == "prod" ]]; then
  # non snapshot release to production env
  nohup java -jar /home/ubuntu/RELEASE/${version}/aws-0.0.1.jar > /home/ubuntu/log.txt 2>&1 & 
else
  # snapshot release to non production env
  nohup java -jar /home/ubuntu/SNAPSHOT/${version}/aws-0.0.1-SNAPSHOT.jar > /home/ubuntu/log.txt 2>&1 &
fi
echo $! > /home/ubuntu/pid.file