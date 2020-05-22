task abc {
String base = "URL"
def slurper = new JsonSlurper()

def app_data = slurper.parseText(base.toURL().text)

def FileWriter mFile = new FileWriter(".........../gradle.properties")
}