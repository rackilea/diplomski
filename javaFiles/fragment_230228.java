import groovy.json.JsonOutput

def json(Map map) {
    return new JsonOutput().toJson(map)
}

println json([test: 1])