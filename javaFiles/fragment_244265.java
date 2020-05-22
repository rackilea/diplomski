Blob blob = rs.getBlob(4);

                            int blobLength = (int) blob.length();  
                            byte[] blobAsBytes = blob.getBytes(1, blobLength);
                            //release the blob and free up memory. (since JDBC 4.0)
                            blob.free();

                            ByteBuffer buff = ByteBuffer.wrap(blobAsBytes);

                            Object obj = PofSerializerHelper.deserialize1(buff);