import json

with open('some_text_file.txt') as txtfile:
    data = {'filedata': txtfile.read()}

json_data = json.dumps(data)