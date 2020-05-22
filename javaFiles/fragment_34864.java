import requests
import json
import sys
from requests.auth import HTTPBasicAuth

data = '{"BP_TSM": "22"}'                       # curl -d
headers = {'content-type': 'application/json'}  # curl -H
auth = HTTPBasicAuth('trial', 'trial')          # curl -u

req = requests.post(                            # curl -X POST
    'http://httpbin.org/post',
    auth=auth,
    data=data,
    headers=headers)
sys.stdout.write(req.text)         # Display JSON on stdout
returned_data = req.json()
my_ip = returned_data["origin"]    # Query value from JSON
print("My public IP is", my_ip)