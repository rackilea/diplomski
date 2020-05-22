use multipart form in jsp 
and server side use following code.

for(FileItem item : multiparts){
    if(!item.isFormField()){
        String name = new File(item.getName()).getName();
        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
        request.setAttribute("photoname", name);
    }else{
        // here get value of other parameter which is not file type
        System.out.println(item.getFieldName()+" = "+item.getString());
    }
}