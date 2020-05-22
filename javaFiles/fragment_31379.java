Person p=new Person(pf.getFirstname(),pf.getLastName(),pf.getAge());


    try {
        File dest = null;
        String str = "C:/tt/"+pf.getFile().getOriginalFilename();
        File dir = new File(str);
        dir.createNewFile();
        pf.getFile().transferTo(dir);
        p.setFilename(str);
        InputStream inputStream=pf.getFile().getInputStream();
         repository.linkFileToMyDoc(p,inputStream,pf.getFile().getOriginalFilename());
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    repository.save(p);
    model.addAttribute("PersonForm",pf);
    return "personview";
}