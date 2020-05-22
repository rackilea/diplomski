import groovy.json.*

def json = '{"name":"john", "surname":"doe", "languages": ["groovy", "python"]}'

def obj = new JsonSlurper().parseText(json)

assert obj.name == "john"
assert obj.surname == "doe"

assert obj.languages.containsAll("python", "groovy")