protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    response.setContentType("text/plain");

    StringBuffer jb = new StringBuffer();
    String line = null;
    BufferedReader reader = request.getReader();
    while ((line = reader.readLine()) != null)
        jb.append(line);

    String img64 = jb.toString();   
    //check if the image is really a base64 png, maybe a bit hard-coded
    if(img64 != null && img64.startsWith("data:image/png;base64,")){
        //Remove Content-type declaration
        img64 = img64.substring(img64.indexOf(',') + 1);            
    }else{
        response.setStatus(403);
        out.print("Formato immagine non corretto!");
        return;
    }   
    try{
        InputStream stream = new ByteArrayInputStream(Base64.getDecoder().decode(img64.getBytes()));  
        BufferedImage bfi = ImageIO.read(stream);
        String path = getServletConfig().getServletContext().getRealPath("saved_annotations/saved.png");
        File outputfile = new File(path);
        outputfile.createNewFile();
        ImageIO.write(bfi , "png", outputfile);
        bfi.flush();
        response.setStatus(200);
        out.print("L'immagine e' stata salvata con successo!");         
    }catch(IOException e){  
        e.printStackTrace();
        response.setStatus(500);
        out.print("Errore durante il salvataggio dell'immagine: " + e.getMessage());      
    }
}