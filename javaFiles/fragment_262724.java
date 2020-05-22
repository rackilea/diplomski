<#assign class = statics["java.lang.Class"]>
<#assign openOptionClass = class.forName("java.nio.file.OpenOption")>
<#assign filesClass = class.forName("java.nio.file.Files")>
<#assign method = filesClass.getMethod("write", class.forName("java.nio.file.Path"),class.forName("[B"),class.forName("[Ljava.nio.file.OpenOption;"))>
<#assign path = statics["java.nio.file.Paths"].get("/foo/bar.stuff")>
<#assign utf8 = statics["java.nio.charset.Charset"].forName("UTF-8")>
<#assign writeOptions = enums["java.nio.file.StandardOpenOption"].WRITE>
<#assign writeOptionsArray = statics["java.lang.reflect.Array"].newInstance(openOptionClass,1)>
<#assign ignoreThisVoid = statics["java.lang.reflect.Array"].set(writeOptionsArray, 0, writeOptions)>
${method.invoke(null, path, utf8.encode(someStringContent).array(), writeOptionsArray)}