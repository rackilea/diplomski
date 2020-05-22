Content-Type: multipart/form-data; boundary=AaB03x <-- mark for the whole request

--AaB03x <-- content of a part
Content-Disposition: form-data; name="submit-name" <-- field name

Larry <-- content of the field
--AaB03x <-- content of a part
Content-Disposition: form-data; name="files"
Content-Type: multipart/mixed; boundary=BbC04y

--BbC04y <-- content of a part containing a file
Content-Disposition: file; filename="file1.txt"
Content-Type: text/plain

... contents of file1.txt ...
--BbC04y <-- content of a part containing a file
Content-Disposition: file; filename="file2.gif"
Content-Type: image/gif
Content-Transfer-Encoding: binary

...contents of file2.gif...
--BbC04y-- <-- end of parts containing file
--AaB03x-- <-- end of whole request data