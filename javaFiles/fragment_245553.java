String filename = filters.getPeriod() + "_" +filters.getRegion() ;
httpServletResponse.setContentType("application/octet-stream");
httpServletResponse.setHeader("Content-Disposition", "attachment; filename="+filename+".xls");
ServletOutputStream outputStream = httpServletResponse.getOutputStream();
Path fileIn = Paths.get(filename);
Files.copy(fileIn, outputStream); 
outputStream.flush();
return NONE;