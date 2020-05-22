package forum7673323;

import java.io.File;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class FileAdapter extends XmlAdapter <String, File>{

    @Override
    public String marshal(File file) throws Exception {
        if(null == file) {
            return null;
        }
        return file.getPath();
    }

    @Override
    public File unmarshal(String path) throws Exception {
        return new File(path);
    }

}