xml = new groovy.xml.MarkupBuilder() 
xmldata = xml.Plugins(nextid: '10') {
   Target(name: 'default.auth') {
     Port(protocol: 'https') {
       mkp.yield 8080
     }
   }
}