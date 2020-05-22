/**
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.test.mht.core;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.BASE64Decoder;

/**
 * File to parse and decompose *.mts file in its constituting parts.
 * @author Manish Shukla 
 */

public class MHTParser implements IConstants
{
    private File mhtFile;
    private File outputFolder;

    public MHTParser(File mhtFile, File outputFolder) {
        this.mhtFile = mhtFile;
        this.outputFolder = outputFolder;
    }

    /**
     * @throws Exception
     */
    public void decompress() throws Exception
    {
        BufferedReader reader = null;

        String type = "";
        String encoding = "";
        String location = "";
        String filename = "";
        String charset = "utf-8";
        StringBuilder buffer = null;

        try
        {
            reader = new BufferedReader(new FileReader(mhtFile));

            final String boundary = getBoundary(reader);
            if(boundary == null)
                throw new Exception("Failed to find document 'boundary'... Aborting");

            String line = null;
            int i = 1;
            while((line = reader.readLine()) != null)
            {
                String temp = line.trim();
                if(temp.contains(boundary)) 
                {
                    if(buffer != null) {
                        writeBufferContentToFile(buffer,encoding,filename,charset);
                        buffer = null;
                    }

                    buffer = new StringBuilder();
                }else if(temp.startsWith(CONTENT_TYPE)) {
                    type = getType(temp);
                }else if(temp.startsWith(CHAR_SET)) {
                    charset = getCharSet(temp);
                }else if(temp.startsWith(CONTENT_TRANSFER_ENCODING)) {
                    encoding = getEncoding(temp);
                }else if(temp.startsWith(CONTENT_LOCATION)) {
                    location = temp.substring(temp.indexOf(":")+1).trim();
                    i++;
                    filename = getFileName(location,type);
                }else {
                    if(buffer != null) {
                        buffer.append(line + "\n");
                    }
                }
            }

        }finally 
        {
            if(null != reader)
                reader.close();
        }

    }

    private String getCharSet(String temp) 
    {
        String t = temp.split("=")[1].trim();
        return t.substring(1, t.length()-1);
    }

    /**
     * Save the file as per character set and encoding 
     */
    private void writeBufferContentToFile(StringBuilder buffer,String encoding, String filename, String charset) 
    throws Exception
    {

        if(!outputFolder.exists())
            outputFolder.mkdirs();

        byte[] content = null; 

        boolean text = true;

        if(encoding.equalsIgnoreCase("base64")){
            content = getBase64EncodedString(buffer);
            text = false;
        }else if(encoding.equalsIgnoreCase("quoted-printable")) {
            content = getQuotedPrintableString(buffer);         
        }
        else
            content = buffer.toString().getBytes();

        if(!text)
        {
            BufferedOutputStream bos = null;
            try
            {
                bos = new BufferedOutputStream(new FileOutputStream(filename));
                bos.write(content);
                bos.flush();
            }finally {
                bos.close();
            }
        }else 
        {
            BufferedWriter bw = null;
            try
            {
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), charset));
                bw.write(new String(content));
                bw.flush();
            }finally {
                bw.close();
            }
        }
    }

    /**
     * When the save the *.mts file with 'utf-8' encoding then it appends '=EF=BB=BF'</br>
     * @see http://en.wikipedia.org/wiki/Byte_order_mark
     */
    private byte[] getQuotedPrintableString(StringBuilder buffer) 
    {
        //Set<String> uniqueHex = new HashSet<String>();
        //final Pattern p = Pattern.compile("(=\\p{XDigit}{2})*");

        String temp = buffer.toString().replaceAll(UTF8_BOM, "").replaceAll("=\n", "");

        //Matcher m = p.matcher(temp);
        //while(m.find()) {
        //  uniqueHex.add(m.group());
        //}

        //System.out.println(uniqueHex);

        //for (String hex : uniqueHex) {
            //temp = temp.replaceAll(hex, getASCIIValue(hex.substring(1)));
        //}     

        return temp.getBytes();
    }

    /*private String getASCIIValue(String hex) {
        return ""+(char)Integer.parseInt(hex, 16);
    }*/
    /**
     * Although system dependent..it works well
     */
    private byte[] getBase64EncodedString(StringBuilder buffer) throws Exception {
        return new BASE64Decoder().decodeBuffer(buffer.toString());
    }

    /**
     * Tries to get a qualified file name. If the name is not apparent it tries to guess it from the URL.
     * Otherwise it returns 'unknown.<type>'
     */
    private String getFileName(String location, String type) 
    {
        final Pattern p = Pattern.compile("(\\w|_|-)+\\.\\w+");
        String ext = "";
        String name = "";
        if(type.toLowerCase().endsWith("jpeg"))
            ext = "jpg";
        else
            ext = type.split("/")[1];

        if(location.endsWith("/")) {
            name = "main";
        }else
        {
            name = location.substring(location.lastIndexOf("/") + 1);

            Matcher m = p.matcher(name);
            String fname = "";
            while(m.find()) {
                fname = m.group();
            }

            if(fname.trim().length() == 0)
                name = "unknown";
            else
                return getUniqueName(fname.substring(0,fname.indexOf(".")), fname.substring(fname.indexOf(".") + 1, fname.length()));
        }
        return getUniqueName(name,ext);
    }

    /**
     * Returns a qualified unique output file path for the parsed path.</br>
     * In case the file already exist it appends a numarical value a continues
     */
    private String getUniqueName(String name,String ext)
    {
        int i = 1;
        File file = new File(outputFolder,name + "." + ext);
        if(file.exists())
        {
            while(true)
            {
                file = new File(outputFolder, name + i + "." + ext);
                if(!file.exists())
                    return file.getAbsolutePath();
                i++;
            }
        }

        return file.getAbsolutePath();
    }

    private String getType(String line) {
        return splitUsingColonSpace(line);
    }

    private String getEncoding(String line){
        return splitUsingColonSpace(line);
    }

    private String splitUsingColonSpace(String line) {
        return line.split(":\\s*")[1].replaceAll(";", "");
    }

    /**
     * Gives you the boundary string
     */
    private String getBoundary(BufferedReader reader) throws Exception 
    {
        String line = null;

        while((line = reader.readLine()) != null)
        {
            line = line.trim();
            if(line.startsWith(BOUNDARY)) {
                return line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\""));
            }
        }

        return null;
    }
}