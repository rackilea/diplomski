BaseService service = new BaseService(proteu, hili);

ByteArrayOutputStream baos = new ByteArrayOutputStream();
//my pdf code
service.getHeader().contentTypePDF();
service.getHeader().noCache();
service.getOut().write(baos.toByteArray());