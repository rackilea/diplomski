package com.WeLoveStackOverflow.JavaJNAUnlinkTest;

import java.io.File;    
import com.sun.jna.Library;
import com.sun.jna.Native;

public class Main {
    private static CStdLib cStdLib;

    // Here you specify prototypes of native C methods to be called during runtime
    // Because unlink(char *path) uses pointer to const char as argument, a wrapper class StringByReference is used to convert data types
    // Link to other examples at the end of this post
    public interface CStdLib extends Library {
        int unlink(StringByReference path);
    }

    public static void main(String[] args) {

        // Here I'm declaring libc usage, but you can link anything. Even your own libraries
        cStdLib = (CStdLib)Native.loadLibrary("c", CStdLib.class);

        Logger.INFO("Source file: " + args[0]);
        Logger.INFO("Target file: " + args[1]);
        moveFile(args[0],args[1]);
    }

    private static boolean moveFile(String sourceFilePath, String targetFilePath) {
        boolean fileStatus = false;
        File sourceFile = new File(sourceFilePath );
        File targetFile = new File(targetFilePath );
        if(sourceFile.canRead() && sourceFile.canWrite() ) {
            if(targetFile.exists()) {
                fileStatus = targetFile.delete();
                if(!fileStatus) {
                    Logger.ERROR("Target deletion failed");
                }
            }

            fileStatus = sourceFile.renameTo(targetFile);

            if(!fileStatus) {
                Logger.ERROR("RenameTo method failed");
                Logger.INFO("Trying to copy file and unlink the original");

                // ToDo: add copy method

                // That's where we convert String to char*
                StringByReference unlinkPath=new StringByReference(sourceFilePath);
                int status=cStdLib.unlink(unlinkPath);

                if(status==0){
                    Logger.INFO("Unlink succeeded");
                }else {
                    Logger.ERROR("Unlink also failed");
                    return false;
                }
            } else {
                Logger.INFO("Move succeeded");
            }
        } else {
            Logger.ERROR("Cannot read file");
            return false;
        }
        return true;
    }
}