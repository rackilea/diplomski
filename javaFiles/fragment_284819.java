InputStream source = connection.getInputStream();
OutputStream target = response.getOutputStream();

int FILE_CHUNK_SIZE = 1024 * 4;
byte[] chunk = new byte[FILE_CHUNK_SIZE]; 
int n =0;
while ( (n = source.read(chunk)) != -1 ) {
    target.write(chunk, 0, n);
}