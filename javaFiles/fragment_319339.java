dist: xenial
sudo: required
language: java

before_script:
  - psql -c 'create database travis_ci_test' -U postgres

before_install:
  - sudo apt-get update
  - sudo apt-get --yes remove postgresql\*
  - sudo apt-get install -y postgresql-11 postgresql-client-11
  - sudo cp /etc/postgresql/{9.6,11}/main/pg_hba.conf
  - sudo service postgresql restart 11

env:
  global:
    - PGUSER=postgres
    - PGPORT=5432

script:
  - psql -c "SELECT version();"