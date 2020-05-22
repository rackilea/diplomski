language: java

dist: trusty
sudo: required

addons:
  apt:
    packages:
      - mysql-server-5.6
      - mysql-client-core-5.6
      - mysql-client-5.6

jdk:
 - oraclejdk8

services:
  - mysql

script:
  - ./gradlew check;