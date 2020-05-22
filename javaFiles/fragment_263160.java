import json
import base64

st_test = {"test": "测试内容"}
body = json.dumps(st_test, ensure_ascii=False)
print body

body = body.replace(' ', '')
print body

res = base64.b64encode(body)
print res
print (res == 'eyJ0ZXN0Ijoi5rWL6K+V5YaF5a65In0=')