import static groovy.io.FileType.FILES
import info.magnolia.jcr.util.NodeUtil
import org.apache.commons.lang.StringUtils
import info.magnolia.cms.util.ContentUtil

class Globals {
 static def folderName = '//some/folder/in/filesystem/on/server'
}

def loadImageFolder() {
 session = ctx.getJCRSession("resources")
 parentFolder = session.getNode("/templating-kit/jelinek-image/obrazky-produkty")

 new File(Globals.folderName).eachFileRecurse(FILES) {

  name = it.name
  // set file name
  extension = StringUtils.substringAfterLast(name, '.')
  name = StringUtils.substringBeforeLast(name, '.')

  // persist
  resource = NodeUtil.createPath(parentFolder,name , "mgnl:content")
  // persistResource
  resource.setProperty("mgnl:template", "resources:binary")
  resource.setProperty("extension", extension)

  binary = resource.addNode("binary", "mgnl:resource")
  binary.setProperty("jcr:data", new FileInputStream(it.absolutePath))
  binary.setProperty("extension", extension)
  binary.setProperty("fileName", name)
  binary.setProperty("jcr:mimeType", "image/"+extension)
  binary.setProperty("size", it.length())

 }
 session.save()
}

loadImageFolder() 
return 'done'