file_name ="test.zip"
if file_name:
    files = {"file": open("test.zip", "rb")}
else:
    files = {"dummy_file": "nothing"}
url = "http://localhost:8080/test_war/test/test"
r = requests.post(url, data={"name": "test"}, files=files)
print r.text
print r.status_code