val bo = new ByteArrayOutputStream()
val zo = new ZipOutputStream(bo)
zo.putNextEntry(new ZipEntry("example entry"))

// v prints the entry header bytes v
println(bo.toString())

zo.write("hello".getBytes())
zo.flush();

// v still only the entry header bytes v
println(bo.toString())