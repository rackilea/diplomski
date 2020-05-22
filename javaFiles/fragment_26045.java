POST /upload/storage/v1/b/myBucket/o?uploadType=resumable HTTP/1.1
Host: www.googleapis.com
Authorization: Bearer your_auth_token
Content-Length: 38
Content-Type: application/json; charset=UTF-8
X-Upload-Content-Type: image/jpeg
X-Upload-Content-Length: 2000000
{
  "name": "myObject"
}