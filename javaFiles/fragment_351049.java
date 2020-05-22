String text = "ALTER DATABASE, ALTER TABLE, ALTER VIEW, CREATE DATABASE, CREATE PROCEDURE, CREATE SCHEMA, CREATE TABLE";

String[] terms = {ALTER DATABASE, ALTER TABLE, ALTER VIEW, CREATE DATABASE, CREATE PROCEDURE, CREATE SCHEMA, CREATE TABLE};

String[] replaceWith = {"","","","","","",""}; // whatever you replace with

for(int i = 0; i < terms; i++) {
    // may want to account for uppercase/lower case here too
    text = text.replaceAll(terms[i],replaceWith[i]);
}