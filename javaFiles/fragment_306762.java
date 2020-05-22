String description = ""+"Desceiption about the image";


            dos.writeBytes("Content-Disposition: form-data; name=\"description\"" + lineEnd); 
            //dos.writeBytes("Content-Type: text/plain; charset=UTF-8" + lineEnd);
            //dos.writeBytes("Content-Length: " + description.length() + lineEnd);
            dos.writeBytes(lineEnd);
            dos.writeBytes(description); // mobile_no is String variable
            dos.writeBytes(lineEnd);