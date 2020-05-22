import json
import subprocess

# send a Python list...
p = subprocess.Popen("java -jar "hi.jar", stdin=subprocess.PIPE, stdout=subprocess.PIPE)
o, e = p.communicate(json.dumps(["haha", "hehe"]))

>>> print o
handleInput():  got a JSONArray (list) containing 2 elements
haha
hehe

# send a Python dictionary...
p = subprocess.Popen("java -jar "hi.jar", stdin=subprocess.PIPE, stdout=subprocess.PIPE)
o, e = p.communicate(json.dumps({"hee": "haw", "blah": "blah"}))
>>> print o
handleInput():  got a JSONObject (map) containing 2 items
hee: haw
blah: blah