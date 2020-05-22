# $ pip install pyjwt
import jwt
import time

kid = "myKeyId"  
keyFile = "/pathToFile/AuthKey.p8"
key = ""
with open(keyFile, 'r') as myFile:
    key = myFile.read()

print(key)

timeNow = int(round(time.time()))
time3Months = timeNow + 86400*90

claims = {
    'iss': teamID,
    'iat': timeNow,
    'exp': time3Months,
    'aud': 'https://appleid.apple.com',
    'sub': app_id,
}


secret = jwt.encode(claims, key, algorithm='ES256', headers={'kid': kid})
print("secret:")
print(secret)
client_secret = secret.decode("utf-8")
print(client_secret)