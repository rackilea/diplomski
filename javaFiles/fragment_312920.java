@Grab('net.lingala.zip4j:zip4j:2.2.8')
import net.lingala.zip4j.io.outputstream.ZipOutputStream;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.EncryptionMethod;

import org.apache.commons.io.IOUtils

flowFile = session.get()
if(!flowFile) return

flowFile = session.write(flowFile, {inputStream, outputStream ->
    byte[] inputByteArray = IOUtils.toByteArray(inputStream)
    inputStream.close() // this is what was missing in the original code

    ByteArrayOutputStream outputByteStream = new ByteArrayOutputStream()
    ZipOutputStream outputZipStream = new ZipOutputStream(outputByteStream, "password".toCharArray())

    //init the zip parameters
    ZipParameters zipParams = new ZipParameters()
    zipParams.setEncryptFiles(true)
    zipParams.setEncryptionMethod(EncryptionMethod.AES)
    zipParams.setFileNameInZip("records.csv")

    outputZipStream.putNextEntry(zipParams)
    outputZipStream.write(inputByteArray)
    outputZipStream.closeEntry()

    outputZipStream.close()
    outputByteStream.close()

    outputStream.write(outputByteStream.toByteArray())
} as StreamCallback)

session.transfer(flowFile, REL_SUCCESS)