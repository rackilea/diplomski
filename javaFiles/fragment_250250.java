import java.io.*;
import java.util.*;

class Main {

  public static class FileData {
    public String id;
    public String name;
    public String path;

    // store parent of this file or folder. If value is null, mean file/folder in root
    public String parentId; 

    public boolean isFolder;
  }

  public static void main(String[] args) {
    ArrayList<String> filePaths = new ArrayList<String>();

    // inserting some dummy values
    filePaths.add("/a/b/file1");
    filePaths.add("/a/b/file2");
    filePaths.add("/a/b/file3");
    filePaths.add("/a/b/file3");
    filePaths.add("/a/b/file4");
    filePaths.add("/b/d/file5");
    filePaths.add("/e/c/file6");

    HashMap<String, Integer> pathId = new HashMap<>();

    HashMap<String, Integer> mCheck = new HashMap<>();

    ArrayList<FileData> fileDataSql = new ArrayList<>();

    int cntId = 1;

    for(String s:filePaths) {
      String[] sSplit = s.split("/");
      for(int i=1; i<sSplit.length; i++) {
        if(!pathId.containsKey(sSplit[i])) {
          pathId.put(sSplit[i], cntId);
          cntId++;
        }
        FileData fileDataObj = new FileData();
        fileDataObj.id = Integer.toString(pathId.get(sSplit[i]));
        fileDataObj.name = sSplit[i];

        // Here I am checking if this is the first element or not, if yes then it has null parentId and / as path
        if(i == 1) {
          fileDataObj.parentId = "null";
          fileDataObj.path = "/";
        } else {
          fileDataObj.parentId = Integer.toString(pathId.get(sSplit[i-1]));
          fileDataObj.path = "/" + sSplit[i-1];
        }

        if(i == sSplit.length-1) {
          fileDataObj.isFolder = false;
        } else {
          fileDataObj.isFolder = true;
        }
        if(!mCheck.containsKey(sSplit[i])) {
          mCheck.put(sSplit[i], 1);
          fileDataSql.add(fileDataObj);
        }
      }
    }

    for(FileData obj : fileDataSql) {
      System.out.println(obj.id + " " + obj.name + " " + obj.path + " " + obj.parentId + " " + obj.isFolder);
    }
  }
}