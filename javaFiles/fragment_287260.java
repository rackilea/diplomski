PropertyInfo pi = new PropertyInfo();
pi.setName("maquinaLog");
pi.setNamespace(NAMESPACE);
pi.setValue(ML);
pi.setType(ML.getClass());
request.addProperty(pi);
request.addAttribute("xmlns:obe","http://schemas.datacontract.org/2004/07/OberthurService.Entidades");